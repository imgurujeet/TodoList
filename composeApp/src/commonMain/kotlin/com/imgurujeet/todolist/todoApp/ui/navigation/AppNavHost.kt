package com.imgurujeet.todolist.todoApp.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavHost(startDestination: NavRoute= NavRoute.SplashScreen, navController: NavHostController)  {

    NavHost(
        navController = navController,
        startDestination = startDestination
    ){
        composable<NavRoute.SplashScreen> {
            SplashScreen()

        }
        composable<NavRoute.DashBoard> {

        }
        composable<NavRoute.HomeScreen> {  }
        composable<NavRoute.TodoList> {  }

    }

}

@Composable
fun SplashScreen() {
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            "First Screen using CMP"
        )
    }
}