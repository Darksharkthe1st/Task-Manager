package com.example.taskmanager.ui.screens

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
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.taskmanager.R
import com.example.taskmanager.data.DataSource
import com.example.taskmanager.data.Task
import com.example.taskmanager.ui.TaskViewModel
import com.example.taskmanager.ui.theme.TaskManagerTheme


enum class TaskManagerScreen(
    @StringRes val title: Int,
    @get:Composable val topBar: (String) -> Unit
) {
    Home(title = R.string.home, ),
    CreateTask(title = R.string.create_task),
    Menu(title = R.string.menu),
    Settings(title = R.string.settings),
    Shop(title = R.string.shop),
    Streak(title = R.string.streak),

}

@Composable
fun TaskManagerApp(
    modifier: Modifier = Modifier,
    viewModel: TaskViewModel = TaskViewModel(),
    navController: NavHostController = rememberNavController()
) {

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = TaskManagerScreen.valueOf(
        backStackEntry?.destination?.route ?: TaskManagerScreen.Home.name
    )

    Scaffold(
        modifier = modifier,
        topBar = { AppBar(title = currentScreen.title) },
        bottomBar = { BottomBar() }
    ) { innerPadding ->
        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = TaskManagerScreen.Home.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            //Home Screen:
            composable(route = TaskManagerScreen.Home.name) {
                HomeScreen()
            }

            //Create Task Screen:
            composable(route = TaskManagerScreen.CreateTask.name) {
                createTask()
            }

            //Menu Screen:
            composable(route = TaskManagerScreen.Menu.name) {
                Menu()
            }

            //Settings Screen:
            composable(route = TaskManagerScreen.Settings.name) {
                SettingScreen()
            }

            //Shop Screen:
            composable(route = TaskManagerScreen.Shop.name) {
                Shop()
            }

            //Streak Screen:
            composable(route = TaskManagerScreen.Streak.name) {
                StreakScreen()
            }






        }
    }


    Column() {
        AppBar(
            modifier = Modifier.weight(2f)
        )
        HomeScreen(modifier = Modifier.weight(19.5f))
        BottomBar()
    }
}

@Composable
fun BottomBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
    ) {
        Button(
            onClick = {  },
            modifier = Modifier
                .fillMaxWidth(),
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(containerColor = Color(68,94,145))
        ) {
            Icon(imageVector = Icons.Filled.Menu, contentDescription = null)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(modifier: Modifier = Modifier, @StringRes title: Int) {
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
                    stringResource(title),
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.weight(1f)
                )
            }
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    TaskManagerTheme {
        TaskManagerApp()
    }
}
