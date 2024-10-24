package com.example.taskmanager.ui.screens

import android.util.Log
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taskmanager.R
import com.example.taskmanager.data.DataSource
import com.example.taskmanager.data.Task
import com.example.taskmanager.ui.theme.TaskManagerTheme

var onCheckClick: (Int) -> Unit = { }

@Composable
fun HomeScreen(modifier: Modifier = Modifier, onCheck: (Int) -> Unit) {
    onCheckClick = onCheck
    LazyColumn(
        modifier = modifier
    ) {
        items(DataSource.tasks) { task ->
            TaskCard(
                task = task
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    TaskManagerTheme {
        HomeScreen {  }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeAppBar(modifier: Modifier = Modifier,
               @StringRes title: Int,
               onNewClick: () -> Unit) {
    TopAppBar(
        title = {
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(2.dp)
            ) {
                Text(
                    stringResource(R.string.app_title),
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.weight(1f)
                )

                Button(
                    onClick = onNewClick,
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(
                        stringResource(R.string.new_task)
                    )
                }
            }
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier
    )
}

//Represents one task
@Composable
fun TaskCard(
    task: Task,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp),
        colors = CardColors(
            containerColor = colorResource(task.difficulty.color),
            contentColor = Color.Black,
            disabledContentColor = Color.LightGray,
            disabledContainerColor = Color.LightGray
        )
    ) {
        Column() {
            //The header
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
            ) {
                Text(
                    text = task.name,
                    style = MaterialTheme.typography.displayLarge,
                    modifier = Modifier
                        .weight(3f)
                )
                Spacer(modifier = Modifier)
                Column(
                    modifier = Modifier
                        .weight(weight = 1f, fill = true),
                    verticalArrangement = Arrangement.Bottom,
                ) {
                    Card(
                        colors = CardColors(
                            containerColor = colorResource(task.category.color),
                            contentColor = Color.White,
                            disabledContentColor = colorResource(task.category.color),
                            disabledContainerColor = colorResource(task.category.color)
                        )
                    ) {
                        Text(
                            text = task.category.name,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp)
                        )
                    }
                    Button(
                        onClick = {
                            Log.d("Size: ", "" + DataSource.tasks.size)
                            onCheckClick(task.id)
                            Log.d("Size: ", "" + DataSource.tasks.size)
                        },
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(4.dp)
                    ) {
                        Icon(imageVector = Icons.Filled.Check, contentDescription = null)
                    }
                }
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .background(color = Color.LightGray)
            ) {
                Text(
                    text = "Date Due: ${task.date.month}/${task.date.date}/${task.date.year}",
                    modifier = Modifier.weight(1f),
                    color = Color.Black
                )
                Text(
                    text = "Priority: ${task.priority.name}",
                    color = Color.Black
                )
            }
            Text(
                text = task.description
            )
        }
    }
}