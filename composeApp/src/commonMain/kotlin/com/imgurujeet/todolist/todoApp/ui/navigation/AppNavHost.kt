package com.imgurujeet.todolist.todoApp.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.imgurujeet.todolist.todoApp.ui.navigation.bottomNavBar.BottomNavBar
import com.imgurujeet.todolist.todoApp.ui.navigation.bottomNavBar.SideNavRail
import com.imgurujeet.todolist.todoApp.ui.screens.NotesScreen
import com.imgurujeet.todolist.todoApp.ui.screens.OnBoardingScreen
import com.imgurujeet.todolist.todoApp.ui.screens.ProfileScreen
import com.imgurujeet.todolist.todoApp.ui.screens.TaskScreen
import com.imgurujeet.todolist.todoApp.ui.screens.TodoBackgroundScreen
import com.imgurujeet.todolist.todoApp.ui.screens.homescreen.HomeScreen

@Composable
fun AppNavHost()  {

    val navController = rememberNavController()



    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {

        val isWideScreen = maxWidth >= 600.dp

        if (isWideScreen) {
            //  Tablet / Laptop / Landscape
            Row(modifier = Modifier.fillMaxSize()) {

                SideNavRail(navController) //  LEFT SIDE

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxSize()
                ) {
                    AppNavContent(navController)
                }
            }
        } else {
            //  Phone (portrait)
            Scaffold(
                bottomBar = {
                    BottomNavBar(navController)
                }
            ) {

                    AppNavContent(navController)

            }
        }
    }



}


@Composable
fun RootNav(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoute.OnBoardingScreen
    ) {
        composable<NavRoute.OnBoardingScreen> {
            OnBoardingScreen(
                 onClick = {
                    navController.navigate(NavRoute.HomeScreen)
                }
            )
        }

        composable<NavRoute.HomeScreen> {
            AppNavHost() //
        }
    }
}




@Composable
fun AppNavContent(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavRoute.HomeScreen
    ) {
        composable<NavRoute.HomeScreen> {
            HomeScreen()
        }
        composable<NavRoute.TaskScreen> { TaskScreen() }
        composable<NavRoute.TodoList> { }
        composable <NavRoute.NotesScreen> { NotesScreen() }
        composable<NavRoute.Profile> { ProfileScreen() }
    }
}


