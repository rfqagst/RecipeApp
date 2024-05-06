package com.example.tugasfrontendcompose.ui.screen.detail

import android.util.Log
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.tugasfrontendcompose.ui.components.ExpandableRecipeCard

@Composable
fun DetailFoodScren(modifier: Modifier, detailFoodViewModel: DetailFoodViewModel) {

    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(targetValue = if (expandedState) 180f else 0f)

    val detailFood = detailFoodViewModel.detailFood.value ?: emptyList()


    Column(modifier.padding(16.dp)) {

        detailFood.firstOrNull()?.let { foodDetail ->
            AsyncImage(
                model = foodDetail.strMealThumb,
                contentDescription = "",
                modifier = Modifier
                    .width(365.dp)
                    .height(225.dp)
                    .clip(RoundedCornerShape(10.dp))
                ,
                contentScale = ContentScale.Crop
            )


            Spacer(modifier = Modifier.height(12.dp))
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = cardColors(containerColor = Color.White),
                border = BorderStroke(2.dp, Color(0xFFEFEFEF))
            ) {
                Text(
                    modifier = Modifier.padding(10.dp),
                    text = foodDetail.strMeal ?: "",

                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )

            }
            Spacer(modifier = Modifier.height(20.dp))

            ExpandableRecipeCard(
                title = "Instructions",
                onClick = {
                    expandedState = !expandedState
//                detailFoodViewModel.getDetailFoodById()
                }, expandedState = expandedState,
                instructions = foodDetail.strInstructions ?: "",
                rotationState = rotationState,
                ingredients = ""
            )
            Spacer(modifier = Modifier.height(20.dp))
        }

    }


}