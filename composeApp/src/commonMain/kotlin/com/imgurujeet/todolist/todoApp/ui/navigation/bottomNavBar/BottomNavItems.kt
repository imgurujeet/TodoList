package com.imgurujeet.todolist.todoApp.ui.navigation.bottomNavBar

import com.imgurujeet.todolist.todoApp.ui.navigation.NavRoute
import org.jetbrains.compose.resources.DrawableResource
import todolist.composeapp.generated.resources.Res
import todolist.composeapp.generated.resources.Res.readBytes
import todolist.composeapp.generated.resources.briefcase
import todolist.composeapp.generated.resources.calendar
import todolist.composeapp.generated.resources.document_text
import todolist.composeapp.generated.resources.home
import todolist.composeapp.generated.resources.profile_user



sealed class BottomNavItems(val route: NavRoute, val title: String, val iconRes: String){
    object HomeScreen : BottomNavItems(NavRoute.HomeScreen, "Home", "files/home.json")
    object TaskScreen : BottomNavItems(NavRoute.TaskScreen, "Task", "files/task.json")
    object TodoList : BottomNavItems(NavRoute.NotesScreen, "Notes", "files/book.json")
    object Profile : BottomNavItems(NavRoute.Profile, "Profile", "files/profile_icon.json")

}



