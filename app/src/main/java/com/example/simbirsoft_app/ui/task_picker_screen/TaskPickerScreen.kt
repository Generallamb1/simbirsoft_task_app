package com.example.simbirsoft_app.ui.task_picker_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.simbirsoft_app.data.AppDatabase
import com.example.simbirsoft_app.jsonReader.TaskResponse
import com.example.simbirsoft_app.jsonReader.mapTaskResponse
import com.example.simbirsoft_app.navigation.NewTaskScreen
import com.example.simbirsoft_app.navigation.TaskScreen
import com.example.simbirsoft_app.view.TaskCreateView
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId

@Composable
fun TaskPickerScreen(navController: NavController){


    val context = LocalContext.current
    val taskResponse : MutableList<TaskResponse> = mapTaskResponse(context)
    val viewModel = hiltViewModel<TaskPickerViewModel>()
    val state = viewModel.state.collectAsState()

    DayTaskTable(dayList = taskResponse, navController)

    Box(modifier = Modifier.fillMaxSize()){
        FloatingActionButton(
            onClick = { navController.navigate(NewTaskScreen) },
            modifier = Modifier
                .align(BottomEnd)
                .padding(36.dp)
        )
        {
            Icon(imageVector = Icons.Default.Add, contentDescription = "New task")
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DayTaskTable(dayList: List<TaskResponse>, navController: NavController){

    val datePickerState = rememberDatePickerState()

    LazyColumn() {
        item {

            val selectedDateMillis = datePickerState.selectedDateMillis

            val selectedDate: LocalDate? = selectedDateMillis?.let {
                Instant.ofEpochMilli(it).atZone(ZoneId.systemDefault()).toLocalDate()
            }

            val filteredTasks = if (selectedDate != null) {
                dayList.filter { task ->
                    isTaskForSelectedDate(task.dateStart, task.dateFinish, selectedDate)
                }
            } else {
                emptyList()
            }


            DatePicker(state = datePickerState)
            filteredTasks.forEach{

                HourTaskTable(task = it, navController, datePickerState)
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HourTaskTable(task : TaskResponse, navController: NavController, datePickerState: DatePickerState){



    Card(
        modifier = Modifier
            .padding(bottom = 5.dp)
            .height(40.dp)
            .fillMaxWidth()
            .border(BorderStroke(0.dp, color = Color.Transparent))
            .clickable {
                navController.navigate(
                    TaskScreen(
                        task.id,
                        task.getFormattedStartDate(),
                        task.getFormattedFinishDate(),
                        task.name,
                        task.description,
                    )
                )
            }
    ) {
        Row(modifier = Modifier.padding(vertical = 5.dp)) {
            Text(
                text = task.getFormattedStartDate() + "-" + task.getFormattedFinishDate(),
                fontSize = 20.sp,
                modifier = Modifier.padding(horizontal = 10.dp)
            )
            Spacer(modifier = Modifier.width(100.dp))
            Text(text = task.name, fontSize = 20.sp)
        }
        Divider()
    }
}




fun isTaskForSelectedDate(taskStart: Long, taskFinish: Long, selectedDate: LocalDate): Boolean {
    val zoneId = ZoneId.systemDefault()

    val startDate = Instant.ofEpochMilli(taskStart).atZone(zoneId).toLocalDate()
    val finishDate = Instant.ofEpochMilli(taskFinish).atZone(zoneId).toLocalDate()

    return !selectedDate.isBefore(startDate) && !selectedDate.isAfter(finishDate)
}