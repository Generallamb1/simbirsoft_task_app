package com.example.simbirsoft_app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.simbirsoft_app.jsonReader.TaskResponse
import com.example.simbirsoft_app.models.Task
import com.example.simbirsoft_app.view.TaskCreateView
import com.example.simbirsoft_app.view.TaskPickerScreen
import com.example.simbirsoft_app.view.TaskView
import kotlinx.serialization.Serializable

@Composable
fun NavController(): NavController {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = MainScreen) {
        composable<MainScreen> { TaskPickerScreen(navController = navController) }
        composable<NewTaskScreen> { TaskCreateView(navController = navController) }
        composable<TaskScreen> {
            TaskView(navController = navController, navArgs = it.toRoute<TaskScreen>())
        }
    }

    return navController
}

@Serializable
object MainScreen

@Serializable
object NewTaskScreen

@Serializable
data class TaskScreen(
    var id: Int,
    var dateStart: String? = "",
    var dateFinish: String? = "",
    var name: String,
    var description: String,
)

