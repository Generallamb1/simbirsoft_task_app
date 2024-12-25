package com.example.simbirsoft_app.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.simbirsoft_app.jsonReader.TaskResponse
import com.example.simbirsoft_app.domain.models.Task
import com.example.simbirsoft_app.navigation.TaskScreen


@Composable
fun TaskView(navController: NavController, navArgs: TaskScreen){

    var taskName by remember { mutableStateOf(navArgs.name)}
    var taskDate by remember { mutableStateOf(navArgs.dateStart)}
    var taskDescription by remember { mutableStateOf(navArgs.description) }

    Column(modifier = Modifier.padding(horizontal = 15.dp)) {

        TaskViewText(
            taskName,
            navArgs,
            TextStyle(fontWeight = FontWeight.Medium, fontSize = 30.sp)
        )

        TaskViewText(
            taskDate.toString(),
            navArgs,
            TextStyle(fontWeight = FontWeight.Medium, fontSize = 30.sp)
        )

        TextField(
            value = navArgs.dateStart + ":" + navArgs.dateFinish,
            onValueChange = {
                taskDate = it
                            },
            modifier = Modifier.padding(vertical = 10.dp),
            textStyle = TextStyle(
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp
            ),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                errorContainerColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent
            )
        )

        TextField(
            value = taskDescription,
            onValueChange = {
                taskDescription = it
                navArgs.description = it
                            },
            modifier = Modifier.padding(vertical = 10.dp),
            textStyle = TextStyle(
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp
            ),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                errorContainerColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent
            )
        )

    }
}

@Composable
private fun TaskViewText(
    taskData: String,
    navArgs: TaskScreen,
    textStyle: TextStyle
) {
    var taskName1 = taskData
    TextField(
        value = taskName1,
        onValueChange = {
            taskName1 = it
            navArgs.name = it
        },
        modifier = Modifier.padding(bottom = 10.dp),
        textStyle = textStyle,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            errorContainerColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent
        )
    )
}