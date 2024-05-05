package com.example.tugasfrontendcompose.ui.navigation

sealed class Screen (val route: String) {
    data object Home  : Screen ("home")
    data object LocalFood  : Screen ("localfood")
    data object About  : Screen ("about")
    data object Detail  : Screen ("detail")
}