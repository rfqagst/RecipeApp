package com.example.tugasfrontendcompose.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(modifier: Modifier) {
    Column(modifier = modifier) {
        Box(modifier = Modifier.background(color = Color.Red)) {
            Column {
                Text(text = "Hallo, Rifqi")
                Text(text = "What do you want to cook today?")

            }
        }
        Text(text = "Food Categories")
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    HomeScreen(modifier = Modifier.fillMaxSize())
}