package com.imgurujeet.todolist.todoApp.ui.navigation.bottomNavBar

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
import androidx.compose.ui.unit.dp

@Composable
fun BottomNavBar(navHost: NavHostController) {

    val items = listOf(
        BottomNavItems.HomeScreen,
        BottomNavItems.TaskScreen,
        BottomNavItems.TodoList,
        BottomNavItems.Profile
    )

    val navBackStackEntry by navHost.currentBackStackEntryAsState()
    //val currentRole = navBackStackEntry?.destination?.route
    val currentDestination = navBackStackEntry?.destination


    NavigationBar {
        items.forEach { screen ->
            NavigationBarItem(
                icon = {
                    Icon(painterResource(screen.iconRes), contentDescription = null)
                },
                label = {
                    Text(text = screen.title)
                },
                selected = currentDestination?.hierarchy?.any {
                    it.route == screen.route::class.qualifiedName
                } == true,
                onClick = {
                    navHost.navigate(screen.route) {
                        popUpTo(navHost.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true

                    }
                }

            )


        }

    }

}



@Composable
fun SideNavRail(navController: NavHostController) {

    val items = listOf(
        BottomNavItems.HomeScreen,
        BottomNavItems.TaskScreen,
        BottomNavItems.TodoList,
        BottomNavItems.Profile
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationRail {
        items.forEach { screen ->
            NavigationRailItem(
                icon = {
                    Icon(
                        painterResource(screen.iconRes),
                        contentDescription = screen.title
                    )
                },
                label = { Text(screen.title) },
                selected = currentDestination?.hierarchy?.any {
                    it.route == screen.route::class.qualifiedName
                } == true,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}




@Composable
fun AdaptiveNavigation(
    navController: NavHostController
) {
    androidx.compose.foundation.layout.BoxWithConstraints {
        val isWideScreen = maxWidth >= 600.dp // tablet / laptop / wide phone

        if (isWideScreen) {
            SideNavRail(navController)
        } else {
            BottomNavBar(navController)
        }
    }
}

