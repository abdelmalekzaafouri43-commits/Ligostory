package com.example.data.db

import androidx.room.TypeConverter
import com.example.data.QuizQuestion
import org.json.JSONArray
import org.json.JSONObject

class StoryTypeConverters {

    @TypeConverter
    fun fromQuizQuestions(questions: List<QuizQuestion>?): String {
        if (questions.isNullOrEmpty()) return "[]"
        val array = JSONArray()
        questions.forEach { q ->
            val obj = JSONObject().apply {
                put("question", q.question)
                put("options", JSONArray(q.options))
                put("correctAnswerIndex", q.correctAnswerIndex)
                put("explanation", q.explanation)
            }
            array.put(obj)
        }
        return array.toString()
    }

    @TypeConverter
    fun toQuizQuestions(json: String?): List<QuizQuestion> {
        if (json.isNullOrBlank()) return emptyList()
        return try {
            val array = JSONArray(json)
            val list = mutableListOf<QuizQuestion>()
            for (i in 0 until array.length()) {
                val obj = array.getJSONObject(i)
                val question = obj.optString("question", "")
                val optionsArray = obj.optJSONArray("options")
                val options = mutableListOf<String>()
                if (optionsArray != null) {
                    for (j in 0 until optionsArray.length()) {
                        options.add(optionsArray.optString(j, ""))
                    }
                }
                val correctAnswerIndex = obj.optInt("correctAnswerIndex", 0)
                val explanation = obj.optString("explanation", "")
                list.add(
                    QuizQuestion(
                        question = question,
                        options = options,
                        correctAnswerIndex = correctAnswerIndex,
                        explanation = explanation
                    )
                )
            }
            list
        } catch (e: Exception) {
            emptyList()
        }
    }
}
