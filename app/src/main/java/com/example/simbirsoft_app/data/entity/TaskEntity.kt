package com.example.simbirsoft_app.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Tasks")
data class TaskEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var dateStart: Long,
    var dateFinish: Long,
    val name: String,
    val description: String
)