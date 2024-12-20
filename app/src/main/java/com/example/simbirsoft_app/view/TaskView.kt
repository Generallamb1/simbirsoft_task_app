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
import com.example.simbirsoft_app.models.Task



@Composable
fun TaskView(task: Task){

    var taskName by remember { mutableStateOf(task.taskName)}
    var taskDate by remember { mutableStateOf(task.dateStart)}
    var taskDescription by remember { mutableStateOf(task.taskDescription) }

    Column(modifier = Modifier.padding(horizontal = 15.dp)) {

        TextField(
            value = taskName,
            onValueChange = {
                taskName = it
                task.taskName = it
                            },
            modifier = Modifier.padding(bottom = 10.dp),
            textStyle = TextStyle(
                fontWeight = FontWeight.Medium,
                fontSize = 30.sp
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
            value = task.dateStart + "-" + task.dateFinish,
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
                task.taskDescription = it
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



//        TextField(
//            textFieldValue = task.taskName,
//            fontSize = 30.sp,
//            fontWeight = FontWeight.Bold,
//            modifier = Modifier.padding(vertical = 20.dp)
//        )
//        Text(
//            text = task.dateStart + "-" + task.dateFinish,
//            fontWeight = FontWeight.Medium,
//            fontSize = 20.sp,
//            modifier = Modifier.padding(bottom = 10.dp)
//        )
//        Text(
//            text = task.taskDescription,
//            fontSize = 20.sp,
//            fontWeight = FontWeight.Normal
//        )

    }
}