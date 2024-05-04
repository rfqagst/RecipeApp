package com.example.tugasfrontendcompose

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tugasfrontendcompose.ui.navigation.NavGraph
import com.example.tugasfrontendcompose.ui.navigation.bottomNavItems

@Composable
fun RecepyApp() {

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination?.route


    Scaffold(
        Modifier.fillMaxSize(),
        bottomBar = {
            BottomBarComponent(navHostController = navController)
        }
    ) { paddingValues ->
        NavGraph(navController = navController, modifier = Modifier.padding(paddingValues))

    }
}


@Composable
fun BottomBarComponent(navHostController: NavHostController) {

    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    var selected by remember {
        mutableIntStateOf(0)
    }

    NavigationBar(
        containerColor = Color.White,
        modifier = Modifier.border(1.dp, Color(0xFFD9D9D9))
    ) {
        bottomNavItems.forEachIndexed { index, bottomNavItem ->
            NavigationBarItem(
                selected = index == selected,
                icon = {
                    Icon(
                        painterResource(id = if (index == selected)
                            bottomNavItem.selectedIcon else bottomNavItem.unselectedIcon),
                        contentDescription = bottomNavItem.title,
                        modifier = Modifier.size(25.dp),
                        tint = if (currentDestination?.hierarchy?.any { it.route == bottomNavItem.route } == true) {
                            Color(0xFFCE1717)
                        } else {
                            Color(0xFFA8A3A3)
                        },
                    )
                },
                label = { Text(bottomNavItem.title) },
                onClick = {
                    selected = index
                    navHostController.navigate(bottomNavItem.route)
                }
            )

        }
    }

}