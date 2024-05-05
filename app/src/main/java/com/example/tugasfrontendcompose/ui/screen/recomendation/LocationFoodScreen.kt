package com.example.tugasfrontendcompose.ui.screen.recomendation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LocationFoodScreen(modifier: Modifier, locationFoodViewModel: LocationFoodViewModel) {



    Column {



        LazyVerticalGrid(
            GridCells.Fixed(2)
        ) {
        }
    }

}