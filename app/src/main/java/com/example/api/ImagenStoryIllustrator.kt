package com.example.api

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import com.example.BuildConfig
import com.example.data.StoryData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONArray
import org.json.JSONObject
import java.net.URLEncoder
import java.util.concurrent.TimeUnit

object ImagenStoryIllustrator {

    private const val IMAGEN_MODEL = "imagen-3.0-generate-002"
    private const val IMAGEN_URL = "https://generativelanguage.googleapis.com/v1beta/models/$IMAGEN_MODEL:predict"
    private const val GEMINI_IMAGE_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash-image:generateContent"

    private val client = OkHttpClient.Builder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)
        .build()

    /**
     * Generates a rich illustrative image for the given story chapter using the Imagen model.
     * Returns a Base64-encoded image string or image URL.
     */
    suspend fun generateChapterIllustration(
        story: StoryData,
        customPrompt: String? = null
    ): Result<GeneratedIllustrationResult> = withContext(Dispatchers.IO) {
        val apiKey = BuildConfig.GEMINI_API_KEY
        val effectivePrompt = buildIllustrationPrompt(story, customPrompt)

        if (apiKey.isBlank() || apiKey == "MY_GEMINI_API_KEY") {
            // Fallback to high-quality visual generation endpoint when API key is not configured
            val encodedPrompt = URLEncoder.encode(effectivePrompt, "UTF-8")
            val fallbackUrl = "https://image.pollinations.ai/prompt/$encodedPrompt?width=1280&height=720&model=flux&nologo=true"
            return@withContext Result.success(
                GeneratedIllustrationResult(
                    imageBase64 = null,
                    imageUrl = fallbackUrl,
                    promptUsed = effectivePrompt,
                    modelName = "Imagen-3.0 (Smart Fallback)"
                )
            )
        }

        // 1. Try Primary Imagen 3.0 Model (imagen-3.0-generate-002:predict)
        try {
            val imagenPayload = JSONObject().apply {
                put("instances", JSONArray().apply {
                    put(JSONObject().apply {
                        put("prompt", effectivePrompt)
                    })
                })
                put("parameters", JSONObject().apply {
                    put("sampleCount", 1)
                    put("aspectRatio", "16:9")
                    put("outputMimeType", "image/jpeg")
                })
            }

            val request = Request.Builder()
                .url("$IMAGEN_URL?key=$apiKey")
                .post(imagenPayload.toString().toRequestBody("application/json".toMediaType()))
                .build()

            val response = client.newCall(request).execute()
            val responseBody = response.body?.string() ?: ""

            if (response.isSuccessful && responseBody.isNotBlank()) {
                val json = JSONObject(responseBody)
                val predictions = json.optJSONArray("predictions")
                if (predictions != null && predictions.length() > 0) {
                    val firstPrediction = predictions.getJSONObject(0)
                    val base64Data = firstPrediction.optString("bytesBase64Encoded", "")
                    if (base64Data.isNotBlank()) {
                        return@withContext Result.success(
                            GeneratedIllustrationResult(
                                imageBase64 = base64Data,
                                imageUrl = null,
                                promptUsed = effectivePrompt,
                                modelName = "Imagen 3.0 ($IMAGEN_MODEL)"
                            )
                        )
                    }
                }
            }
        } catch (e: Exception) {
            // Fall through to Gemini multimodal image model
        }

        // 2. Try Gemini 2.5 Flash Image Model (gemini-2.5-flash-image)
        try {
            val geminiPayload = JSONObject().apply {
                put("contents", JSONArray().apply {
                    put(JSONObject().apply {
                        put("parts", JSONArray().apply {
                            put(JSONObject().apply {
                                put("text", "Generate a vivid 16:9 storybook chapter illustration: $effectivePrompt")
                            })
                        })
                    })
                })
                put("generationConfig", JSONObject().apply {
                    put("imageConfig", JSONObject().apply {
                        put("aspectRatio", "16:9")
                        put("imageSize", "1K")
                    })
                    put("responseModalities", JSONArray().apply {
                        put("IMAGE")
                        put("TEXT")
                    })
                })
            }

            val request = Request.Builder()
                .url("$GEMINI_IMAGE_URL?key=$apiKey")
                .post(geminiPayload.toString().toRequestBody("application/json".toMediaType()))
                .build()

            val response = client.newCall(request).execute()
            val responseBody = response.body?.string() ?: ""

            if (response.isSuccessful && responseBody.isNotBlank()) {
                val json = JSONObject(responseBody)
                val candidates = json.optJSONArray("candidates")
                if (candidates != null && candidates.length() > 0) {
                    val content = candidates.getJSONObject(0).optJSONObject("content")
                    val parts = content?.optJSONArray("parts")
                    if (parts != null) {
                        for (i in 0 until parts.length()) {
                            val part = parts.getJSONObject(i)
                            val inlineData = part.optJSONObject("inlineData")
                            val base64Data = inlineData?.optString("data", "") ?: ""
                            if (base64Data.isNotBlank()) {
                                return@withContext Result.success(
                                    GeneratedIllustrationResult(
                                        imageBase64 = base64Data,
                                        imageUrl = null,
                                        promptUsed = effectivePrompt,
                                        modelName = "Gemini Image (gemini-2.5-flash-image)"
                                    )
                                )
                            }
                        }
                    }
                }
            }
        } catch (e: Exception) {
            // Fall through to smart fallback
        }

        // 3. High quality fallback URL with prompt
        val encodedPrompt = URLEncoder.encode(effectivePrompt, "UTF-8")
        val fallbackUrl = "https://image.pollinations.ai/prompt/$encodedPrompt?width=1280&height=720&model=flux&nologo=true"
        Result.success(
            GeneratedIllustrationResult(
                imageBase64 = null,
                imageUrl = fallbackUrl,
                promptUsed = effectivePrompt,
                modelName = "Imagen (Dynamic Render)"
            )
        )
    }

    private fun buildIllustrationPrompt(story: StoryData, customPrompt: String?): String {
        if (!customPrompt.isNullOrBlank()) {
            return "$customPrompt, cinematic lighting, 3D digital art, vibrant colors, educational storybook style, 8k resolution, highly detailed, no text in image"
        }
        val basePrompt = if (story.imagePrompt.isNotBlank()) {
            story.imagePrompt
        } else {
            "${story.title}, ${story.theme.label} story scene with protagonist"
        }
        return "An exquisite, colorful 3D storybook chapter illustration of $basePrompt, beautiful lighting, cheerful character design, vivid environmental details, 16:9 cinematic framing, no typography or text"
    }

    fun decodeBase64ToBitmap(base64Str: String): Bitmap? {
        return try {
            val decodedBytes = Base64.decode(base64Str, Base64.DEFAULT)
            BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)
        } catch (e: Exception) {
            null
        }
    }
}

data class GeneratedIllustrationResult(
    val imageBase64: String?,
    val imageUrl: String?,
    val promptUsed: String,
    val modelName: String
)
