package com.example.taskmanager.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import java.io.File
import java.util.*
@Preview(showBackground = true)
@Composable
fun Shop(
    modifier: Modifier = Modifier
) {
    Column (
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
        LazyColumn(
            modifier = Modifier.weight(20f)
        ) {

        }
    }
}

//Shop is supposed to show a collection of themes to purchase.

@Composable
fun Theme(colors: CardColors, theme_name: String){
    Card(
        colors = colors
    ) {
        Column {
            Spacer(modifier = Modifier.fillMaxWidth())
            Text(text = theme_name)
        }
    }
}

//We need to randomly create a set of themes for the guys to get and have them randomly named


//fun generate_theme_name() : String {
//    val names = listOf("")
//
//    val fruits = listOf("Apple", "Banana", "Cherry", "Date")
//    val randomFruit = fruits.random()
//    println(randomFruit)
//    return ""
//}



//fun readFileWords(fileName: String): List<String> {
//    val fileName = "example.txt"
//    val wordList = readFileWords(fileName)
//    println("Word list from $fileName:")
//    wordList.forEachIndexed { index, word ->
//        println("${index + 1}. $word")
//    }
//
//    return try {
//        File(fileName).readLines().map { it.toLowerCase().trim() }.distinct()
//    } catch (e: Exception) {
//        println("Error reading file: ${e.message}")
//        emptyList()
//    }
//}



