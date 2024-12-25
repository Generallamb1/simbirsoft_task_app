package com.example.simbirsoft_app.ui.task_picker_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simbirsoft_app.data.TasksRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskPickerViewModel @Inject constructor(val tasksRepository: TasksRepository) : ViewModel(){
    private val stateMutable = MutableStateFlow(TaskPickerState())
    val state = stateMutable.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            loadTasksFromDatabase()
        }
    }

    private suspend fun loadTasksFromDatabase(){
        stateMutable.value = stateMutable.value.copy(
            taskList = tasksRepository.getAllTasks()
        )
    }
}