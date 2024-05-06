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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.tugasfrontendcompose.ui.components.HomeCategoriesCard
import com.example.tugasfrontendcompose.ui.components.HomeFoodCard
import com.example.tugasfrontendcompose.ui.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier,
    homeViewModel: HomeViewModel,
    navController: NavHostController,
    searchViewModel: SearchViewModel
) {
    val categories = homeViewModel.categories.value ?: emptyList()
    val categoriesFood = homeViewModel.categoriesFood.value ?: emptyList()
    val searchRecipeResult = searchViewModel.recipeName.value ?: emptyList()

    val activeCategory = homeViewModel.activeCategory

    var textSearch by remember {
        mutableStateOf("")
    }
    var activeSearch by remember {
        mutableStateOf(false)
    }


    Column {
        Box(
            modifier = Modifier
                .background(color = Color(0xFFCE1717))
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Column() {
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
                Spacer(modifier = Modifier.height(12.dp))
                Column(modifier = Modifier.clip(RoundedCornerShape(10.dp))) {
                    SearchBar(
                        shape = RoundedCornerShape(10.dp),
                        query = textSearch,
                        onQueryChange = {
                            textSearch = it
                            searchViewModel.searchRecipeByName(textSearch)
                        },
                        onSearch = {
                            activeSearch = false
                        },

                        active = activeSearch,
                        onActiveChange = {
                            activeSearch = it
                        },
                        placeholder = {
                            Text(text = "Search Food Recipe", fontSize = 15.sp)
                        },
                        leadingIcon = {
                            Icon(modifier = Modifier.clickable {
                                activeSearch = false
                            }, imageVector = Icons.Default.Search, contentDescription = null)
                        },
                        trailingIcon = {
                            if (activeSearch && textSearch.isNotEmpty()) {
                                Icon(
                                    modifier = Modifier.clickable {
                                        textSearch = ""
                                    },
                                    imageVector = Icons.Default.Close, contentDescription = null
                                )
                            } else if (activeSearch) {
                                Text(
                                    modifier = Modifier.clickable {
                                        activeSearch = false
                                    },
                                    text = "Close",
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xffCE1717)
                                )
                            }
                        }
                    ) {
                        LazyColumn(modifier = Modifier.padding(16.dp)) {
                            items(searchRecipeResult.size) { index ->
                                searchRecipeResult[index]?.let { searchResult ->
                                    val foodId = searchResult.idMeal
                                    HomeFoodCard(
                                        modifier = Modifier.clickable {
                                            navController.navigate(Screen.Detail.route + "/$foodId")
                                        },
                                        foodName = searchResult.strMeal ?: "",
                                        foodImage = searchResult.strMealThumb ?: ""
                                    )
                                }

                            }
                        }

                    }
                }
            }

        }
        Spacer(modifier = Modifier.height(16.dp))

        Column(modifier = modifier.padding(start = 16.dp)) {
            Text(text = "Food Categories", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(11.dp))

            LazyRow {
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
                            modifier = Modifier.clickable {
                                val foodId = categoriesFood.idMeal
                                navController.navigate(Screen.Detail.route + "/$foodId")
                            },
                            foodName = categoriesFood.strMeal ?: "Unknown Meal",
                            foodImage = categoriesFood.strMealThumb ?: "Unknown Image",
                        )
                    }

                }
            }
        }
    }
}
