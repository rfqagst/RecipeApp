package com.example.tugasfrontendcompose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun HomeCategoriesCard(
    modifier: Modifier,
    foodImage: String?,
    foodCategory: String,
    isActive: Boolean
) {
    Box(
        modifier = modifier
            .width(100.dp)
            .height(105.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(if (isActive) Color(0xffCE1616) else Color(0xffEFEFEF)),
        contentAlignment = Alignment.Center
    ) {

        AsyncImage(
            model = foodImage, contentDescription = foodCategory, modifier = Modifier
                .fillMaxSize()
                .padding(6.dp), alignment = Alignment.TopStart
        )

        Text(
            fontSize = 20.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            color = if (isActive) Color.White else Color(0xFF1B1717),
            text = foodCategory,
            modifier = Modifier
                .padding(6.dp)
                .align(Alignment.BottomStart)
        )
    }
}

@Composable
fun HomeFoodCard(modifier: Modifier, foodName: String, foodImage: String) {

    Row(modifier = modifier) {
        Box(
            modifier = Modifier
                .width(112.dp)
                .height(100.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFFEFEFEF)),
            contentAlignment = Alignment.Center
        ) {

            AsyncImage(
                model = foodImage,
                contentDescription = foodName,
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )


        }
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = foodName,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                overflow = TextOverflow.Ellipsis, maxLines = 2
            )
            Spacer(modifier = Modifier.height(8.dp))

        }

    }
    Spacer(modifier = Modifier.height(15.dp))


}

@Composable
fun LocationFilterCard(modifier: Modifier, foodLocation: String, isActive: Boolean) {
    Column(
        modifier = modifier
            .width(100.dp)
            .height(50.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(if (isActive) Color(0xffCE1616) else Color(0xffEFEFEF)),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = foodLocation,
            color = if (isActive) Color.White else Color(0xFF1B1717),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,

            )
    }
}

@Composable
fun LocationFoodCard(modifier: Modifier, foodImage: String?, foodName: String) {
    Column(horizontalAlignment = Alignment.Start) {
        Box(
            modifier.clip(RoundedCornerShape(10.dp))

        ) {
            AsyncImage(
                model = foodImage,
                contentDescription = foodName,
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
        Text(
            modifier = Modifier.padding(start = 11.dp, bottom = 12.dp),
            text = foodName,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold, fontSize = 20.sp
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewCard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
//        HomeCategoriesCard(
//            modifier = Modifier.padding(16.dp),
//            foodImage = painterResource(id = R.drawable.beef),
//            foodCategory = "Beef"
//        )

//        HomeFoodCard(
//            modifier = Modifier,
//            foodName = "Vietnamese Grilled Pork (bun-thit-nuong)",
//            foodCountry = "Brazil",
//            foodImage = painterResource(
//                id = R.drawable.beef
//            )
//        )

//        RecomendationFoodCard(
//            modifier = Modifier, foodImage = painterResource(
//                id = R.drawable.beef
//            ), foodName = "Vietnamese Grilled Pork (bun-thit-nuong)"
//        )

    }
}