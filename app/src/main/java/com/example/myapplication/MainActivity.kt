package com.example.myapplication

import android.app.ActivityManager.TaskDescription
import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                myFunction()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "It is what it is."
        )
        Image(
            painter = painterResource(R.drawable.nerdbob),
            contentDescription = "nerdbob"
        )
    }

}

@Composable
fun myFunction(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.
            fillMaxSize()
    ) {
        aTask(
            modifier = modifier,
            taskName = "My Task",
            taskDesc = "Task Description - The FitnessGram™ Pacer Test is a multistage aerobic capacity test that progressively gets more difficult as it continues. The 20 meter pacer test will begin in 30 seconds. Line up at the start. The running speed starts slowly, but gets faster each minute after you hear this signal. [beep] A single lap should be completed each time you hear this sound. [ding] Remember to run in a straight line, and run as long as possible. The second time you fail to complete a lap before the sound, your test is over. The test will begin on the word start. On your mark, get ready, start.",
            taskDate = "01/13/2000"
        )
    }
}

@Composable
fun aTask(
    modifier: Modifier = Modifier,
    taskName: String,
    taskDesc: String,
    taskDate: String
) {
    //The whole task is a button.
    Button(
        modifier = modifier
            .fillMaxWidth(),
        onClick = {},
        shape = RoundedCornerShape(20.dp),
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = modifier.fillMaxWidth()
        ) {
            Row() {

                Text(
                    text = taskName,
                    fontSize = 36.sp
                )

                Text(
                    text = taskDate,
                    fontSize = 14.sp,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }

            Text(
                text = taskDesc
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun myPreview() {
    MyApplicationTheme {
        myFunction()
    }
}