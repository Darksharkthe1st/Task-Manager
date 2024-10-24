package com.example.taskmanager.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.taskmanager.data.Category
import com.example.taskmanager.data.DataSource
import com.example.taskmanager.data.Personal
import com.example.taskmanager.data.Priority
import com.example.taskmanager.data.Task
import com.example.taskmanager.ui.theme.TaskManagerTheme
import java.util.Date

//This composable is made to take in the input from the user when creating a task
@Composable
fun TaskMakerScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .weight(20f)
                .fillMaxWidth()
        ) {
            Row(
                modifier = modifier
            ) {
//                TextField(value = "Task Name")
                Text(text = "YO")
            }

            createTask()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskMakerPreview() {
    TaskManagerTheme {
        TaskMakerScreen();
    }
}

fun createTask() {
    DataSource.tasks += Task(
        name = "new",
        description = "new",
        date = Date(2024, 9, 8),
        category = Personal(),
        priority = Priority.High
    )
}


@Composable
fun BlueBar(modifier: Modifier){
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(containerColor = Color(68,94,145))
        ) {
            Icon(imageVector = Icons.Filled.Menu, contentDescription = null)
        }
    }
}




