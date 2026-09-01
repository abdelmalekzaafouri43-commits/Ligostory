package com.example.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.CefrLevel
import com.example.data.QuizQuestion
import com.example.data.StoryData
import com.example.data.StoryTheme

@Entity(tableName = "cached_stories")
data class StoryEntity(
    @PrimaryKey
    val id: String,
    val title: String,
    val levelName: String,
    val themeName: String,
    val imagePrompt: String,
    val rawStoryText: String,
    val quizQuestionsJson: String,
    val morale: String = "",
    val generatedImageBase64: String? = null,
    val generatedImageUrl: String? = null,
    val lastReadTimestamp: Long = System.currentTimeMillis()
) {
    fun toStoryData(quizQuestions: List<QuizQuestion>): StoryData {
        val level = try {
            CefrLevel.valueOf(levelName)
        } catch (e: Exception) {
            CefrLevel.A2
        }

        val theme = try {
            StoryTheme.valueOf(themeName)
        } catch (e: Exception) {
            StoryTheme.DAILY_LIFE
        }

        return StoryData(
            id = id,
            title = title,
            level = level,
            theme = theme,
            imagePrompt = imagePrompt,
            rawStoryText = rawStoryText,
            quizQuestions = quizQuestions,
            morale = morale,
            generatedImageBase64 = generatedImageBase64,
            generatedImageUrl = generatedImageUrl
        )
    }

    companion object {
        fun fromStoryData(story: StoryData, quizQuestionsJson: String): StoryEntity {
            return StoryEntity(
                id = story.id,
                title = story.title,
                levelName = story.level.name,
                themeName = story.theme.name,
                imagePrompt = story.imagePrompt,
                rawStoryText = story.rawStoryText,
                quizQuestionsJson = quizQuestionsJson,
                morale = story.morale,
                generatedImageBase64 = story.generatedImageBase64,
                generatedImageUrl = story.generatedImageUrl,
                lastReadTimestamp = System.currentTimeMillis()
            )
        }
    }
}
