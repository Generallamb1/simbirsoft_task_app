package com.example.simbirsoft_app.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.simbirsoft_app.data.entity.TaskEntity
import com.example.simbirsoft_app.viewModel.TaskCreateViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskCreateView(navController: NavController){

    var timePickerState = rememberTimePickerState()

    var taskName: String by remember {mutableStateOf("")}
    var taskDescription: String by remember {mutableStateOf("")}
    var startDate: Long by remember { mutableStateOf(System.currentTimeMillis()) }
    var finishDate: Long by remember { mutableStateOf(System.currentTimeMillis()) }


    Box(modifier = Modifier.padding(36.dp)){
        Column() {
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
            TimePicker(state = timePickerState)
            Button(
                onClick = {
                    navController.popBackStack()
                },
            ) {
                Text("Сохранить")
            }
        }
    }
}