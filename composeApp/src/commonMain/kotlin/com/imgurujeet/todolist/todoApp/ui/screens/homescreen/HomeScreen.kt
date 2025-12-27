package com.imgurujeet.todolist.todoApp.ui.screens.homescreen

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.imgurujeet.todolist.todoApp.ui.screens.TodoBackgroundScreen
import com.imgurujeet.todolist.todoApp.ui.screens.homescreen.components.HomePageContent
import com.imgurujeet.todolist.todoApp.ui.screens.homescreen.components.UserHeader

@Composable
fun HomeScreen(){

    TodoBackgroundScreen {
        HomePageContent()

    }

}