package com.example.tugasfrontendcompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tugasfrontendcompose.ui.screen.AboutScreen
import com.example.tugasfrontendcompose.ui.screen.AvailableRecipeScreen
import com.example.tugasfrontendcompose.ui.screen.DetailFoodScren
import com.example.tugasfrontendcompose.ui.screen.HomeScreen

@Composable
fun NavGraph(navController: NavHostController, modifier: Modifier) {
    NavHost(navController = navController, startDestination = "") {

        composable(route = Screen.Home.route) {
            HomeScreen(modifier = modifier)
        }
        composable(route = Screen.Detail.route) {
            DetailFoodScren(modifier = modifier)
        }
        composable(route = Screen.AvailableRecipe.route) {
            AvailableRecipeScreen(modifier = modifier)
        }
        composable(route = Screen.About.route) {
            AboutScreen(modifier = modifier)
        }

    }
}