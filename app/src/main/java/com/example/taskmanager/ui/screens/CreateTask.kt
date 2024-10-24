package com.example.taskmanager.ui.screens

import android.text.format.DateUtils
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.example.taskmanager.data.DataSource
import com.example.taskmanager.data.Personal
import com.example.taskmanager.data.Priority
import com.example.taskmanager.data.Task
import com.example.taskmanager.ui.theme.TaskManagerTheme
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date

//This composable is made to take in the input from the user when creating a task
@OptIn(ExperimentalMaterial3Api::class)
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
                //Name:
                var name by remember { mutableStateOf("") }
                TextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Task Name") },
                )
                //Description:
                var desc by remember { mutableStateOf("") }
                TextField(
                    value = desc,
                    onValueChange = { desc = it },
                    label = { Text("Task Description") },
                )
                //Priority:
                var expanded by remember { mutableStateOf(false) }
                var priority by remember { mutableStateOf(Priority.None) }
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                        modifier = Modifier.padding(16.dp),
                        offset = DpOffset(x = 20.dp, y = 40.dp)
                    ) {
                        DropdownMenuItem(
                            text = { Text("No Priority") },
                            onClick = {
                                priority = Priority.None
                                expanded = false
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Low Priority") },
                            onClick = {
                                priority = Priority.Low
                                expanded = false
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Medium Priority") },
                            onClick = {
                                priority = Priority.Medium
                                expanded = false
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("High Priority") },
                            onClick = {
                                priority = Priority.High
                                expanded = false
                            }
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Selected item: $priority")
                }
                //Date:
                var showDialog by remember { mutableStateOf(false) }
                val dateState = rememberDatePickerState()
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable(onClick = { showDialog = true }),
                        text = "Choose Date",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.headlineMedium
                    )

                    if (showDialog) {
                        DatePickerDialog(
                            onDismissRequest = { showDialog = false },
                            confirmButton = {
                                Button(onClick = {
                                    showDialog = false
                                }) {
                                    Text(text = "OK")
                                }
                            },
                            dismissButton = {
                                Button(onClick = { showDialog = false }) {
                                    Text(text = "Cancel")
                                }
                            }
                        ) {
                            DatePicker(
                                state = dateState,
                                showModeToggle = true
                            )
                        }
                    }
                }
                //Category:
                //finish palette color picker,
                //finish the name for the category,
                //finish the GUI section (cause it ain't pretty here)

                Button(onClick = {
                    println("Task added!!!")
                    DataSource.tasks += Task(
                        name = name,
                        description = desc,
                        priority = priority,
                        date = Date((dateState.selectedDateMillis?:0L)),



                        category = Personal(),

                    )
                }) {
                    Text("Submit")
                }
            }



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




