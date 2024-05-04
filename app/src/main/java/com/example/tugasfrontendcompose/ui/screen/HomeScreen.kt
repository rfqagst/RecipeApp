package com.example.tugasfrontendcompose.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasfrontendcompose.R
import com.example.tugasfrontendcompose.ui.components.HomeCategoriesCard
import com.example.tugasfrontendcompose.ui.components.HomeFoodCard

@Composable
fun HomeScreen(modifier: Modifier) {
    Column {
        Box(
            modifier = Modifier
                .background(color = Color(0xFFCE1717))
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Hallo, Rifqi",
                    color = Color.White,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "What do you want to cook today?",
                    color = Color.White,
                    fontSize = 20.sp
                )

            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        Column(modifier = modifier.padding(start = 16.dp)) {
            Text(text = "Food Categories", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(11.dp))

            LazyRow {
                items(14) {
                    HomeCategoriesCard(
                        modifier = Modifier.padding(end = 11.dp),
                        foodImage = painterResource(id = R.drawable.beef),
                        foodName = "Beef"
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn(modifier = Modifier.padding(start = 14.dp)) {
                items(11) {
                    HomeFoodCard(
                        modifier = Modifier,
                        foodName = "Burger",
                        foodCountry = "Vietnam",
                        foodImage = painterResource(
                            id = R.drawable.beef
                        )
                    )
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    HomeScreen(modifier = Modifier.fillMaxSize())
}