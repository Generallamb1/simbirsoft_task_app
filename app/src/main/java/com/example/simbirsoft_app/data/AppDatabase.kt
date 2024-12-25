package com.example.simbirsoft_app.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.simbirsoft_app.data.entity.TaskEntity

@Database(entities = [TaskEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao

}