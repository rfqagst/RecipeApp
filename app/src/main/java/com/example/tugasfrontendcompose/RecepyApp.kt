package com.example.tugasfrontendcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tugasfrontendcompose.ui.navigation.NavGraph
import com.example.tugasfrontendcompose.ui.navigation.Screen
import com.example.tugasfrontendcompose.ui.navigation.bottomNavItems

@Composable
fun RecepyApp() {

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination?.route

    Scaffold(
        Modifier.fillMaxSize(),
        topBar = {
            when (currentDestination) {
                Screen.Detail.route -> MainTopBar(title = "Recipe", navController)
                Screen.LocalFood.route -> MainTopBar(title = "Local Food", navController)
                Screen.About.route -> MainTopBar(title = "About", navController)
            }
        },
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
        containerColor = Color(0xFFFBFBFB),
        modifier = Modifier.border(1.dp, Color(0xFFD9D9D9))
    ) {
        bottomNavItems.forEachIndexed { index, bottomNavItem ->
            NavigationBarItem(
                selected = index == selected,
                icon = {
                    Icon(
                        painterResource(
                            id = if (index == selected)
                                bottomNavItem.selectedIcon else bottomNavItem.unselectedIcon
                        ),
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(title: String, navController: NavHostController) {
    TopAppBar(
        title = {
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF121417),
                ), textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth()

            )

        },
        navigationIcon = {
            Icon(
                modifier = Modifier.clickable {
                    navController.popBackStack()
                },
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back"
            )
        },
        modifier = Modifier
            .border(width = 1.dp, color = Color(0xFFD9D9D9))
            .background(Color(0xFFFFFFFF))

    )
}