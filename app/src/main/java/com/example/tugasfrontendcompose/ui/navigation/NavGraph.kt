package com.example.tugasfrontendcompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tugasfrontendcompose.di.Injection
import com.example.tugasfrontendcompose.ui.screen.about.AboutScreen
import com.example.tugasfrontendcompose.ui.screen.detail.DetailFoodScren
import com.example.tugasfrontendcompose.ui.screen.home.HomeScreen
import com.example.tugasfrontendcompose.ui.screen.home.HomeViewModel
import com.example.tugasfrontendcompose.ui.screen.recomendation.RecomendationRecipeScreen

@Composable
fun NavGraph(navController: NavHostController, modifier: Modifier) {
    val context = LocalContext.current

    NavHost(navController = navController, startDestination = Screen.Home.route) {

        composable(route = Screen.Home.route) {
            HomeScreen(
                modifier = modifier,
                homeViewModel = HomeViewModel(foodRepo = Injection.provideRepository(context))
            )
        }
        composable(route = Screen.Detail.route) {
            DetailFoodScren(modifier = modifier)
        }
        composable(route = Screen.AvailableRecipe.route) {
            RecomendationRecipeScreen(modifier = modifier)
        }
        composable(route = Screen.About.route) {
            AboutScreen(modifier = modifier)
        }

    }
}