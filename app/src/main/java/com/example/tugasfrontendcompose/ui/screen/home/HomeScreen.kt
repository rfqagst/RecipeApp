package com.example.tugasfrontendcompose.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasfrontendcompose.ui.components.HomeCategoriesCard
import com.example.tugasfrontendcompose.ui.components.HomeFoodCard

@Composable
fun HomeScreen(modifier: Modifier, homeViewModel: HomeViewModel) {
    val categories = homeViewModel.categories.value ?: emptyList()
    val categoriesFood = homeViewModel.categoriesFood.value ?: emptyList()

    val activeCategory = homeViewModel.activeCategory


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

            LazyRow() {
                items(categories.size) { index ->
                    categories[index]?.let { category ->
                        val isActive = category.strCategory == activeCategory
                        HomeCategoriesCard(
                            modifier = Modifier
                                .padding(end = 11.dp)
                                .clickable {
                                    val categoryValue = category.strCategory ?: "Unknown Category"
                                    homeViewModel.getFoodByCategory(categoryValue)

                                },
                            foodImage = category.strCategoryThumb,
                            foodCategory = category.strCategory ?: "Unknown Category",
                            isActive = isActive
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(25.dp))


            LazyColumn(modifier = Modifier.padding(start = 14.dp)) {
                items(categoriesFood.size) { index ->
                    categoriesFood[index]?.let { categoriesFood ->
                        HomeFoodCard(
                            modifier = Modifier,
                            foodName = categoriesFood.strMeal ?: "Unknown Meal",
                            foodImage = categoriesFood.strMealThumb ?: "Unknown Image",
                            foodCountry = "Vietnam"
                        )
                    }

                }
            }
        }
    }
}
//        @Preview(showBackground = true)
//        @Composable
//        fun Preview() {
////    HomeScreen(modifier = Modifier.fillMaxSize())
//        }