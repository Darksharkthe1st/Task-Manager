package screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.taskmanager.data.Category
import com.example.taskmanager.data.DataSource
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
        Column(
            modifier = Modifier
                .weight(20f)
                .fillMaxWidth()
        ) {
            Row(
                modifier = modifier
            ) {
                Text(
                    text = "Name:",
                    fontSize = 35.sp
                )
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
        desc = "new",
        date = Date(2024, 9, 8),
        category = Category.Personal,
        priority = Priority.High
    )
}

