package com.imgurujeet.todolist.todoApp.ui.navigation.bottomNavBar

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import org.jetbrains.compose.resources.painterResource
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.imgurujeet.todolist.todoApp.ui.screens.TodoBackgroundScreen
import com.imgurujeet.todolist.todoApp.ui.theme.appColors


@Composable
fun BottomNavBar(navHost: NavHostController) {

    val colors = MaterialTheme.appColors

    val items = listOf(
        BottomNavItems.HomeScreen,
        BottomNavItems.TaskScreen,
        BottomNavItems.TodoList,
        BottomNavItems.Profile
    )

    val navBackStackEntry by navHost.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination




    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.linearGradient(
                    listOf(
                        colors.softCyan,
                        colors.lightBlue
                    ),
                    start = Offset(0f, Float.POSITIVE_INFINITY),
                    end = Offset(0f, 0f)


                )
            )
            .drawBehind {
                val strokeWidth = 1.dp.toPx()
                drawLine(
                    color = Color.Gray.copy(alpha = 0.4f),
                    start = Offset(40f, 0f),
                    end = Offset(size.width-40f, 0f),
                    strokeWidth = strokeWidth
                )
            }
    ) {
    NavigationBar(
        containerColor = Color.Transparent
    ){

        items.forEach { screen ->

            val isSelected =
                currentDestination?.hierarchy?.any {
                    it.route == screen.route::class.qualifiedName
                } == true

            NavigationBarItem(
                icon = {
                    Icon(painterResource(screen.iconRes), contentDescription = null)
                },
                label = {
                    Text(
                        text = screen.title,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                        color = if (isSelected) MaterialTheme.appColors.primary else MaterialTheme.appColors.onSoftCyan.copy(alpha = 0.8f),
                    )
                },
                selected = isSelected,
                onClick = {
                    navHost.navigate(screen.route) {
                        popUpTo(navHost.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true

                    }
                }
                ,
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = MaterialTheme.appColors.primary.copy(alpha = 0.2f),
                    selectedIconColor = MaterialTheme.appColors.primary,
                    selectedTextColor = MaterialTheme.appColors.primary,
                   unselectedIconColor = MaterialTheme.appColors.onSoftCyan.copy(alpha = 0.4f),
                    unselectedTextColor = MaterialTheme.appColors.onSoftCyan.copy(alpha = 0.8f)
                )

            )


        }

    }
    }

}



// Navbar for WiderScreen

@Composable
fun SideNavRail(navController: NavHostController) {

    val colors = MaterialTheme.appColors

    val items = listOf(
        BottomNavItems.HomeScreen,
        BottomNavItems.TaskScreen,
        BottomNavItems.TodoList,
        BottomNavItems.Profile
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Box(
        modifier = Modifier
            .fillMaxHeight()
            .background(
                brush = Brush.linearGradient(
                    listOf(
                        colors.softCyan,
                        colors.lightBlue
                    ),
                    end = Offset(Float.POSITIVE_INFINITY,0f ),
                    start = Offset(0f, 0f)


                )
            )
            .drawBehind {
                val strokeWidth = 1.dp.toPx()
                drawLine(
                    color = Color.Gray.copy(alpha = 0.4f),
                    start = Offset(size.width, 40f),
                    end = Offset(size.width, size.height-40f),
                    strokeWidth = strokeWidth
                )
            }
    ) {

        NavigationRail(
            containerColor = Color.Transparent
        ) {
            items.forEach { screen ->

                val isSelected =
                    currentDestination?.hierarchy?.any {
                        it.route == screen.route::class.qualifiedName
                    } == true
                NavigationRailItem(
                    icon = {
                        Icon(
                            painterResource(screen.iconRes),
                            contentDescription = screen.title
                        )
                    },
                    label = {
                        Text(
                            screen.title,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                            color = if (isSelected) MaterialTheme.appColors.primary else MaterialTheme.appColors.onSoftCyan.copy(alpha = 0.8f),
                            )
                    },
                    selected = isSelected,
                    onClick = {
                        navController.navigate(screen.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },

                    colors = NavigationRailItemDefaults.colors(
                        indicatorColor = MaterialTheme.appColors.primary.copy(alpha = 0.2f),
                        selectedIconColor = MaterialTheme.appColors.primary,
                        selectedTextColor = MaterialTheme.appColors.primary,
                        unselectedIconColor = MaterialTheme.appColors.onSoftCyan.copy(alpha = 0.4f),
                        unselectedTextColor = MaterialTheme.appColors.onSoftCyan.copy(alpha = 0.8f)
                    )

                )
            }
        }
    }
}

