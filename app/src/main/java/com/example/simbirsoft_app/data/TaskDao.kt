package com.example.simbirsoft_app.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.simbirsoft_app.data.entity.TaskEntity


@Dao
interface TaskDao {

    @Insert
    suspend fun insert(taskEntity: TaskEntity)

    @Update
    suspend fun update(taskEntity: TaskEntity)

    @Delete
    suspend fun delete(taskEntity: TaskEntity)

    @Query("SELECT * FROM tasks ORDER BY dateStart ASC")
    suspend fun getAllTasks(): MutableList<TaskEntity>
}