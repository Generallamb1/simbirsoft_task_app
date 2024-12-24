package com.example.simbirsoft_app.view

import android.media.audiofx.AudioEffect.Descriptor
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController

@Composable
fun TaskCreateView(navController: NavController){

    var taskName: String by remember {mutableStateOf("")}
    var taskDescription: String by remember {mutableStateOf("")}

    Column {
        TextField(
            value = taskName,
            onValueChange = {taskName = it},
            label = {Text("Название задачи")}
        )
        // TODO: DatePicker
        TextField(
            value = taskDescription, 
            onValueChange = {taskDescription = it},
            label = { Text(text = "Описание задачи")}
        )
    }
}