package com.example.simbirsoft_app.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simbirsoft_app.data.TaskDao
import com.example.simbirsoft_app.data.entity.TaskEntity
import kotlinx.coroutines.launch

class TaskCreateViewModel(private val taskDao: TaskDao) : ViewModel() {

    fun saveTask(task: TaskEntity){
        viewModelScope.launch {
            taskDao.insert(task)
        }
    }

}