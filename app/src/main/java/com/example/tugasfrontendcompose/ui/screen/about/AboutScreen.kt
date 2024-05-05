package com.example.tugasfrontendcompose.ui.screen.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.WorkspacePremium
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasfrontendcompose.R

@Composable
fun AboutScreen(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,

            ) {
            Image(
                modifier = Modifier
                    .width(290.dp)
                    .height(390.dp)
                    .clip(RoundedCornerShape(15.dp)),
                painter = painterResource(id = R.drawable.fhoto),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(11.dp))

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Muhammad Rifqi Agustia", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text(text = "agustiarifqi@gmail.com")
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Column {
            Row {
                Icon(imageVector = Icons.Default.WorkspacePremium, contentDescription = null,tint = Color(0xFFCE1717))
                Spacer(modifier = Modifier.width(6.dp))
                Text(text = "Ilmu Komunikasi", fontSize = 18.sp)
            }
            Spacer(modifier = Modifier.height(6.dp))

            Row {
                Icon(imageVector = Icons.Default.School, contentDescription = null, tint = Color(0xFFCE1717))
                Spacer(modifier = Modifier.width(6.dp))
                Text(text = "Universitas Tebuka",fontSize = 18.sp)
            }
        }
    }
}