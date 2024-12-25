package com.example.simbirsoft_app.domain.models

import com.example.simbirsoft_app.jsonReader.formatTimestamp


data class Task(
    var dateStart: Long,
    var dateFinish: Long,
    var taskName: String,
    var taskDescription: String
)
