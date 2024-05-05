package com.example.tugasfrontendcompose.ui.screen.recomendation

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.tugasfrontendcompose.ui.components.LocationFilterCard
import com.example.tugasfrontendcompose.ui.components.LocationFoodCard

@Composable
fun LocationFoodScreen(modifier: Modifier, locationFoodViewModel: LocationFoodViewModel,navController: NavHostController) {
    val location = locationFoodViewModel.location.value ?: emptyList()
    val foodLocation = locationFoodViewModel.locationFood.value ?: emptyList()
    val activeLocation = locationFoodViewModel.activeLocation


    Column(modifier = modifier.padding(16.dp)) {
        Spacer(modifier = Modifier.height(12.dp))
        LazyRow {
            items(location.size) { index ->
                location[index]?.let { location ->
                    val isActive = location.strArea == activeLocation
                    LocationFilterCard(
                        modifier = Modifier
                            .padding(end = 11.dp)
                            .clickable {
                                val locationValue = location.strArea ?: "Unknown Category"
                                locationFoodViewModel.getFoodByLocation(locationValue)

                            },
                        foodLocation = location.strArea ?: "Unknown Location",
                        isActive = isActive
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        LazyVerticalGrid(
            GridCells.Fixed(2)
        ) {
            items(foodLocation.size) { index ->
                foodLocation[index]?.let { foodLocation ->


                    LocationFoodCard(
                        modifier = Modifier.padding(12.dp),
                        foodImage = foodLocation.strMealThumb,
                        foodName = foodLocation.strMeal ?: "Unknown Meal"
                    )

                }
            }
        }
    }

}