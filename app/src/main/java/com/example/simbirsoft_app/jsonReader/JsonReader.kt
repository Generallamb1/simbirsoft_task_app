package com.example.simbirsoft_app.jsonReader

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File

fun mapTaskResponse(context: Context) : MutableList<TaskResponse>{

    val assetsManager = context.assets

    val jsonString = assetsManager
        .open("tasks.json")
        .bufferedReader()
        .use { it.readText() }

    val gson = Gson()

    val listType = object : TypeToken<MutableList<TaskResponse>>() {}.type

    val obj: MutableList<TaskResponse> = gson.fromJson(jsonString, listType)

    return obj
}