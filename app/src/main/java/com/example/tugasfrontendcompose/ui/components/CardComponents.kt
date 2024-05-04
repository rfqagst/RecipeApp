package com.example.tugasfrontendcompose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasfrontendcompose.R

@Composable
fun HomeCategoriesCard(modifier: Modifier, foodImage: Painter, foodName: String) {
    Box(
        modifier = modifier
            .width(100.dp)
            .height(105.dp)
            .clip(RoundedCornerShape(10.dp)) // Memastikan clip diterapkan untuk memotong konten di dalam border
            .background(Color(0xFFEFEFEF))
    ) {
        Image(
            painter = foodImage,
            contentDescription = null,
            alignment = Alignment.TopStart,
//            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize().padding(6.dp) // Memastikan gambar mengisi box sepenuhnya
        )
        Text(
            fontSize = 20.sp,
            color = Color(0xFF1B1717),
            text = foodName,
            modifier = Modifier.padding(6.dp).align(Alignment.BottomStart) // Menempatkan teks di bawah tengah
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCard() {
    Column(modifier = Modifier.fillMaxSize()) {
        HomeCategoriesCard(
            modifier = Modifier.padding(16.dp), // Menambahkan padding untuk estetika
            foodImage = painterResource(id = R.drawable.beef),
            foodName = "Beef"
        )
    }
}