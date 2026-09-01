package com.example.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface StoryDao {

    @Query("SELECT * FROM cached_stories ORDER BY lastReadTimestamp DESC")
    fun getAllCachedStories(): Flow<List<StoryEntity>>

    @Query("SELECT * FROM cached_stories WHERE id = :id LIMIT 1")
    suspend fun getStoryById(id: String): StoryEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStory(story: StoryEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStories(stories: List<StoryEntity>)

    @Query("DELETE FROM cached_stories WHERE id = :id")
    suspend fun deleteStoryById(id: String)

    @Query("DELETE FROM cached_stories")
    suspend fun clearAll()

    @Query("SELECT COUNT(*) FROM cached_stories")
    fun getCachedStoryCount(): Flow<Int>
}
