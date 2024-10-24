package com.example.taskmanager.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.taskmanager.data.DataSource
import com.example.taskmanager.data.Difficulty
import com.example.taskmanager.data.Task

@Preview(showBackground = true)
@Composable
fun WorkScreen(
    modifier: Modifier = Modifier
) {
    var currentTask: Task? = null
    for (t in DataSource.tasks) {
        if (t.difficulty == Difficulty.Easy) {
            currentTask = t
            break
        }
    }
    if (currentTask == null) {
        for (t in DataSource.tasks) {
            if (t.difficulty == Difficulty.Medium) {
                currentTask = t;
                break
            }
        }
    }

    if (currentTask == null) {
        for (t in DataSource.tasks) {
            if (t.difficulty == Difficulty.Hard) {
                currentTask = t
                break
            }
        }
    }

    if (currentTask == null) {
        for (t in DataSource.tasks) {
            currentTask = t
            break
        }
    }


    if (currentTask != null) {
        Column() {
            Text(text = "Do this task next: ")
            TaskCard(currentTask)
        }
    } else
        Text(text = "You have no tasks to do. Nice work!")
}