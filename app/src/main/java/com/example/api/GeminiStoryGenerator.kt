package com.example.api

import com.example.BuildConfig
import com.example.data.CefrLevel
import com.example.data.QuizQuestion
import com.example.data.StoryData
import com.example.data.StoryTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONArray
import org.json.JSONObject
import java.util.concurrent.TimeUnit

object GeminiStoryGenerator {

    private const val MODEL_NAME = "gemini-3.5-flash"
    private const val BASE_URL = "https://generativelanguage.googleapis.com/v1beta/models/$MODEL_NAME:generateContent"

    private val client = OkHttpClient.Builder()
        .connectTimeout(45, TimeUnit.SECONDS)
        .readTimeout(45, TimeUnit.SECONDS)
        .writeTimeout(45, TimeUnit.SECONDS)
        .build()

    suspend fun generateStory(
        level: CefrLevel,
        theme: StoryTheme
    ): Result<StoryData> = withContext(Dispatchers.IO) {
        val apiKey = BuildConfig.GEMINI_API_KEY
        if (apiKey.isBlank() || apiKey == "MY_GEMINI_API_KEY") {
            return@withContext Result.failure(
                IllegalStateException("Gemini API Key is missing. Please configure GEMINI_API_KEY in AI Studio Secrets panel.")
            )
        }

        val prompt = """
Act as an expert English language teacher and pedagogical engineer.
Create an original interactive English story (100 to 150 words) suitable for target level ${level.label} (${level.name}) on the theme '${theme.label}'.

The story text MUST include three key elements tagged with exact textual markup:
1. Lexicon: [L:word](simple definition in English - CEFR level)
2. Target Verb Tenses: [T:verb](Tense Name - contextual explanation)
3. Conjunctions: [C:word](role in the sentence)

IMPORTANT QUIZ INSTRUCTIONS:
The comprehension quiz MUST NOT test the grammar, lexicon, or conjunctions already explained in the text.
Instead, the quiz MUST focus purely on reading comprehension based on the story content, including:
- Characters and their motivations
- Key events (beginning, middle, and ending)
- The overall moral or lesson of the story

Format your response strictly as valid JSON with no markdown wrapping or code ticks (or inside JSON format):
{
  "title": "Title of story",
  "imagePrompt": "Detailed English image generation prompt for a vivid 3D illustration or 3D render to clarify the meaning of the story",
  "storyText": "Full story text containing [L:...](...), [T:...](...), [C:...](...)",
  "quiz": [
    {
      "question": "Question text in English?",
      "options": ["A) Option 1", "B) Option 2", "C) Option 3"],
      "correctAnswerIndex": 0,
      "explanation": "Explanation of why this answer is correct"
    },
    {
      "question": "Question text in English?",
      "options": ["A) Option 1", "B) Option 2", "C) Option 3"],
      "correctAnswerIndex": 1,
      "explanation": "Explanation"
    },
    {
      "question": "Question text in English?",
      "options": ["A) Option 1", "B) Option 2", "C) Option 3"],
      "correctAnswerIndex": 2,
      "explanation": "Explanation"
    }
  ]
}
""".trimIndent()

        try {
            val jsonPayload = JSONObject().apply {
                put("contents", JSONArray().apply {
                    put(JSONObject().apply {
                        put("parts", JSONArray().apply {
                            put(JSONObject().apply {
                                put("text", prompt)
                            })
                        })
                    })
                })
                put("generationConfig", JSONObject().apply {
                    put("responseMimeType", "application/json")
                    put("temperature", 0.7)
                })
            }

            val request = Request.Builder()
                .url("$BASE_URL?key=$apiKey")
                .post(jsonPayload.toString().toRequestBody("application/json".toMediaType()))
                .build()

            val response = client.newCall(request).execute()
            val responseBody = response.body?.string() ?: ""

            if (!response.isSuccessful) {
                return@withContext Result.failure(
                    Exception("Gemini API HTTP Error ${response.code}: $responseBody")
                )
            }

            val responseJson = JSONObject(responseBody)
            val candidates = responseJson.optJSONArray("candidates")
            if (candidates == null || candidates.length() == 0) {
                return@withContext Result.failure(Exception("No candidates returned from Gemini"))
            }

            val content = candidates.getJSONObject(0).optJSONObject("content")
            val parts = content?.optJSONArray("parts")
            val textOutput = parts?.getJSONObject(0)?.optString("text") ?: ""

            val storyJson = JSONObject(textOutput)
            val title = storyJson.optString("title", "Interactive Story")
            val imagePrompt = storyJson.optString("imagePrompt", "Illustration for English reading story")
            val storyText = storyJson.optString("storyText", "")
            val morale = storyJson.optString("morale", "")

            val quizArray = storyJson.optJSONArray("quiz") ?: JSONArray()
            val questions = mutableListOf<QuizQuestion>()
            for (i in 0 until quizArray.length()) {
                val qObj = quizArray.getJSONObject(i)
                val questionStr = qObj.optString("question", "")
                val optsArray = qObj.optJSONArray("options") ?: JSONArray()
                val optsList = mutableListOf<String>()
                for (j in 0 until optsArray.length()) {
                    optsList.add(optsArray.getString(j))
                }
                val correctIdx = qObj.optInt("correctAnswerIndex", 0)
                val expl = qObj.optString("explanation", "")
                questions.add(QuizQuestion(questionStr, optsList, correctIdx, expl))
            }

            val generatedStory = StoryData(
                id = "ai_gen_${System.currentTimeMillis()}",
                title = title,
                level = level,
                theme = theme,
                imagePrompt = imagePrompt,
                rawStoryText = storyText,
                quizQuestions = questions,
                morale = morale
            )

            Result.success(generatedStory)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
