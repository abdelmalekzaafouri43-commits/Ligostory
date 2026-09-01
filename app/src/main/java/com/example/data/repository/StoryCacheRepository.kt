package com.example.data.repository

import com.example.data.StoryData
import com.example.data.db.StoryDao
import com.example.data.db.StoryEntity
import com.example.data.db.StoryTypeConverters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class StoryCacheRepository(private val storyDao: StoryDao) {

    private val typeConverters = StoryTypeConverters()

    val cachedStories: Flow<List<StoryData>> = storyDao.getAllCachedStories().map { entities ->
        entities.map { entity ->
            val questions = typeConverters.toQuizQuestions(entity.quizQuestionsJson)
            entity.toStoryData(questions)
        }
    }

    val cachedCount: Flow<Int> = storyDao.getCachedStoryCount()

    suspend fun cacheStory(story: StoryData) = withContext(Dispatchers.IO) {
        val questionsJson = typeConverters.fromQuizQuestions(story.quizQuestions)
        val entity = StoryEntity.fromStoryData(story, questionsJson)
        storyDao.insertStory(entity)
    }

    suspend fun getCachedStoryById(id: String): StoryData? = withContext(Dispatchers.IO) {
        val entity = storyDao.getStoryById(id) ?: return@withContext null
        val questions = typeConverters.toQuizQuestions(entity.quizQuestionsJson)
        entity.toStoryData(questions)
    }

    suspend fun deleteCachedStory(id: String) = withContext(Dispatchers.IO) {
        storyDao.deleteStoryById(id)
    }

    suspend fun clearAllCache() = withContext(Dispatchers.IO) {
        storyDao.clearAll()
    }
}
