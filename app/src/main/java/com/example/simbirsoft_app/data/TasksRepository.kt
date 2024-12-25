package com.example.simbirsoft_app.data

import com.example.simbirsoft_app.data.entity.TaskEntity
import com.example.simbirsoft_app.domain.models.Task
import com.example.simbirsoft_app.jsonReader.formatTimestamp
import javax.inject.Inject


class TasksRepository @Inject constructor(
    val taskDao: TaskDao
) {
    suspend fun getAllTasks() : List<Task>{
        return taskDao.getAllTasks().map {
            Task(
                taskName = it.name,
                taskDescription = it.description,
                dateStart = it.dateStart,
                dateFinish = it.dateFinish,
            )
        }
    }

    suspend fun insertTask(task: Task){
        taskDao.insert(
            taskEntity = TaskEntity(
                name = task.taskName,
                description = task.taskDescription,
                dateStart = task.dateStart,
                dateFinish = task.dateFinish
            )
        )
    }

}