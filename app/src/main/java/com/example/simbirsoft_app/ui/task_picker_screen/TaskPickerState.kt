package com.example.simbirsoft_app.ui.task_picker_screen

import com.example.simbirsoft_app.domain.models.Task

data class TaskPickerState(
    val taskList: List<Task> = listOf()
)