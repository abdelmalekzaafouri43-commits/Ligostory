package com.example.util

import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.Typeface
import android.os.Build
import android.provider.MediaStore
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.util.Base64
import com.example.data.StoryData
import com.example.parser.StoryMarkupParser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder

object ImageSaverUtil {
    
    suspend fun saveStoryImageToGallery(context: Context, story: StoryData, userName: String): Result<String> = withContext(Dispatchers.IO) {
        try {
            var illustration: Bitmap? = null
            
            if (!story.generatedImageBase64.isNullOrBlank()) {
                val decodedBytes = Base64.decode(story.generatedImageBase64, Base64.DEFAULT)
                illustration = BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)
            }
            else if (!story.generatedImageUrl.isNullOrBlank()) {
                illustration = downloadBitmap(story.generatedImageUrl)
            }
            else if (story.localDrawableRes != null) {
                illustration = BitmapFactory.decodeResource(context.resources, story.localDrawableRes)
            }
            else if (story.imagePrompt.isNotBlank()) {
                val encodedPrompt = URLEncoder.encode(story.imagePrompt, "UTF-8")
                val url = "https://image.pollinations.ai/prompt/${encodedPrompt}?width=800&height=400&nologo=true"
                illustration = downloadBitmap(url)
            }
            
            val a4Bitmap = createA4StoryImage(illustration, story, userName)
            val savedUri = saveBitmapToMediaStore(context, a4Bitmap, "${story.title} - $userName")
            
            if (savedUri != null) {
                Result.success("Saved A4 Story to gallery!")
            } else {
                Result.failure(Exception("Failed to save to gallery."))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    private fun downloadBitmap(urlString: String): Bitmap? {
        return try {
            val url = URL(urlString)
            val connection: HttpURLConnection = url.openConnection() as HttpURLConnection
            connection.doInput = true
            connection.connect()
            val input: InputStream = connection.inputStream
            BitmapFactory.decodeStream(input)
        } catch (e: Exception) {
            null
        }
    }

    private fun createA4StoryImage(illustration: Bitmap?, story: StoryData, name: String): Bitmap {
        // A4 format at 150 DPI: 1240 x 1754
        val w = 1240
        val h = 1754
        val result = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(result)
        
        // Background
        canvas.drawColor(Color.WHITE)
        
        val margin = 80f
        var currentY = margin

        // 1. Draw Title
        val titlePaint = TextPaint(Paint.ANTI_ALIAS_FLAG).apply {
            color = Color.BLACK
            textSize = 64f
            typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
        }
        val titleLayout = StaticLayout.Builder.obtain(story.title, 0, story.title.length, titlePaint, (w - margin * 2).toInt())
            .setAlignment(Layout.Alignment.ALIGN_CENTER)
            .build()
        canvas.save()
        canvas.translate(margin, currentY)
        titleLayout.draw(canvas)
        canvas.restore()
        currentY += titleLayout.height + 20f

        // 2. Draw Subtitle (Level & Theme)
        val subtitle = "${story.level.label} • ${story.theme.label}"
        val subtitlePaint = TextPaint(Paint.ANTI_ALIAS_FLAG).apply {
            color = Color.DKGRAY
            textSize = 36f
            typeface = Typeface.create(Typeface.DEFAULT, Typeface.ITALIC)
        }
        val subtitleLayout = StaticLayout.Builder.obtain(subtitle, 0, subtitle.length, subtitlePaint, (w - margin * 2).toInt())
            .setAlignment(Layout.Alignment.ALIGN_CENTER)
            .build()
        canvas.save()
        canvas.translate(margin, currentY)
        subtitleLayout.draw(canvas)
        canvas.restore()
        currentY += subtitleLayout.height + 40f

        // 3. Draw Illustration
        if (illustration != null) {
            val imgMaxWidth = w - (margin * 2)
            val imgMaxHeight = 500f
            
            val scale = minOf(imgMaxWidth / illustration.width, imgMaxHeight / illustration.height)
            val scaledW = illustration.width * scale
            val scaledH = illustration.height * scale
            
            val imgLeft = (w - scaledW) / 2f
            
            val srcRect = Rect(0, 0, illustration.width, illustration.height)
            val dstRect = Rect(imgLeft.toInt(), currentY.toInt(), (imgLeft + scaledW).toInt(), (currentY + scaledH).toInt())
            
            canvas.drawBitmap(illustration, srcRect, dstRect, null)
            currentY += scaledH + 40f
        }

        // 4. Draw Story Text
        val plainText = StoryMarkupParser.getPlainText(story.rawStoryText)
        val bodyPaint = TextPaint(Paint.ANTI_ALIAS_FLAG).apply {
            color = Color.BLACK
            textSize = 32f
            typeface = Typeface.create(Typeface.SERIF, Typeface.NORMAL)
        }
        val bodyLayout = StaticLayout.Builder.obtain(plainText, 0, plainText.length, bodyPaint, (w - margin * 2).toInt())
            .setAlignment(Layout.Alignment.ALIGN_NORMAL)
            .setLineSpacing(10f, 1.2f)
            .build()
        canvas.save()
        canvas.translate(margin, currentY)
        bodyLayout.draw(canvas)
        canvas.restore()
        
        // 5. Draw Footer (Saved by ...)
        val footerText = "Saved by: $name"
        val footerPaint = TextPaint(Paint.ANTI_ALIAS_FLAG).apply {
            color = Color.GRAY
            textSize = 28f
            typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
        }
        val textWidth = footerPaint.measureText(footerText)
        val footerX = w - margin - textWidth
        val footerY = h - margin
        canvas.drawText(footerText, footerX, footerY, footerPaint)

        return result
    }

    private fun saveBitmapToMediaStore(context: Context, bitmap: Bitmap, title: String): android.net.Uri? {
        val resolver = context.contentResolver
        val contentValues = ContentValues().apply {
            put(MediaStore.MediaColumns.DISPLAY_NAME, "$title-${System.currentTimeMillis()}.jpg")
            put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                put(MediaStore.MediaColumns.RELATIVE_PATH, android.os.Environment.DIRECTORY_PICTURES + "/LingoStories")
                put(MediaStore.MediaColumns.IS_PENDING, 1)
            }
        }
        
        val imageUri = resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)
        
        if (imageUri != null) {
            resolver.openOutputStream(imageUri)?.use { outputStream ->
                bitmap.compress(Bitmap.CompressFormat.JPEG, 95, outputStream)
            }
            
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                contentValues.clear()
                contentValues.put(MediaStore.MediaColumns.IS_PENDING, 0)
                resolver.update(imageUri, contentValues, null, null)
            }
        }
        return imageUri
    }
}
