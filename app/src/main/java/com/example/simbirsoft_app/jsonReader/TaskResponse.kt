package com.example.simbirsoft_app.jsonReader

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import java.io.Serializable
import java.sql.Timestamp

data class TaskResponse(
    val id: Int,
    @SerializedName("date_start") var dateStart: Long,
    @SerializedName("date_finish") var dateFinish: Long,
    var name: String,
    var description: String,
) : Serializable{
    fun getFormattedStartDate(): String {
        return formatTimestamp(dateStart)
    }

    fun getFormattedFinishDate(): String {
        return formatTimestamp(dateFinish)

    }
}
