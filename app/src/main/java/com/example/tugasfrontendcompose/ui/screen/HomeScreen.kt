package com.example.tugasfrontendcompose.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasfrontendcompose.ui.theme.fontFamily

@Composable
fun HomeScreen(modifier: Modifier) {
    Column(modifier = modifier) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(color = Color(0xFFCE1717))
        ) {
            Column {
                Text(
                    text = "Hallo, Rifqi",
                    color = Color.White,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(text = "What do you want to cook today?",color = Color.White, fontSize = 20.sp)

            }
        }

        Spacer(modifier = Modifier.height(12.dp))
        Text(text = "Food Categories", fontSize = 20.sp, fontWeight = FontWeight.Bold)

    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    HomeScreen(modifier = Modifier.fillMaxSize())
}