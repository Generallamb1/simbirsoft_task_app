package com.example.simbirsoft_app.jsonReader

import java.io.Serializable
import java.sql.Timestamp

data class TaskResponse(
    val id: Int,
    val dateStart: Timestamp,
    val dateFinish: Timestamp,
    val name: String,
    val description: String,
) : Serializable
