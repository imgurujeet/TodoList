package com.imgurujeet.todolist.todoApp.ui.navigation

import kotlinx.serialization.Serializable


@Serializable
sealed class NavRoute{

    @Serializable
    data object SplashScreen : NavRoute()

    @Serializable
    data object OnBoardingScreen : NavRoute()

    @Serializable
    data object DashBoard : NavRoute()

    @Serializable
    data object HomeScreen : NavRoute()

    @Serializable
    data object TodoList : NavRoute()

    @Serializable
    data object TaskScreen : NavRoute()

    @Serializable
    data object NotesScreen : NavRoute()

    @Serializable
    data object Profile : NavRoute()

}

