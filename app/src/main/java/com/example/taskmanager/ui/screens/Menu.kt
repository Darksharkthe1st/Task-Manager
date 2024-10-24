package com.example.taskmanager.ui.screens

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.taskmanager.data.DataSource
import com.example.taskmanager.data.Screen

@Composable
fun Menu (
    modifier: Modifier = Modifier,
    OnOptionClick: (Int) -> Unit,
    OnSelfClick: () -> Unit
) {
    Column (
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LazyColumn(
            modifier = Modifier.weight(20f)
        ) {
            items(DataSource.screens) { screen ->
                ScreenCard(
                    screen = screen,
                    onButtonClick = OnOptionClick
                )
            }
        }
    }
}

@Composable
fun ScreenCard(
    screen: Screen,
    modifier: Modifier = Modifier,
    onButtonClick: (Int) -> Unit
) {
    Button(
        onClick = { onButtonClick(screen.name) },
        modifier = modifier
            .padding(10.dp),
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Row {
            Text(
                modifier = modifier
                    .weight(1f),
                text = stringResource(screen.name),
                style = MaterialTheme.typography.displaySmall,
                textAlign = TextAlign.Center,
                color = Color.Black
            )
        }
    }
}