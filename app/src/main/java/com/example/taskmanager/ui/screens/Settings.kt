package com.example.taskmanager.ui.screens

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taskmanager.data.DataSource
import com.example.taskmanager.data.Setting

@Preview(showBackground = true)
@Composable
fun SettingScreen(
    modifier: Modifier = Modifier
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
            items(DataSource.settings) { setting ->
                SettingCard(
                    setting = setting
                )
            }
        }
    }
}

@Composable
fun SettingCard(
    setting: Setting,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Card(
            modifier = modifier
                .padding(4.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
            border = BorderStroke(1.dp, Color.Black)
        ) {
            Row {
                Text(
                    modifier = modifier
                        .weight(1f)
                        .padding(4.dp),
                    text = setting.name,
                    style = MaterialTheme.typography.displaySmall
                )
                Switch(
                    modifier = modifier
                        .padding(8.dp),
                    checked = setting.settingOn,
                    onCheckedChange = {
                        setting.settingOn = it
                    }
                )
            }
            Text(
                modifier = modifier
                    .padding(4.dp),
                text = setting.desc,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}