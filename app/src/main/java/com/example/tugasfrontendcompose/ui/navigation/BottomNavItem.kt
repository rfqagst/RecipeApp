package com.example.tugasfrontendcompose.ui.navigation

import com.example.tugasfrontendcompose.R


data class BottomNavItem(
    val title: String,
    val selectedIcon: Int,
    val unselectedIcon: Int,
    val route: String
)


var bottomNavItems = listOf(
    BottomNavItem(
        title = "Home",
        route = "home",
        selectedIcon = R.drawable.select_home,
        unselectedIcon = R.drawable.unselect_home
    ),
    BottomNavItem(
        title = "Local Food",
        route = "localfood",
        selectedIcon = R.drawable.select_recom,
        unselectedIcon = R.drawable.unselect_recom
    ),
    BottomNavItem(
        title = "About",
        route = "about",
        selectedIcon = R.drawable.select_about,
        unselectedIcon = R.drawable.unselect_about
    )

)