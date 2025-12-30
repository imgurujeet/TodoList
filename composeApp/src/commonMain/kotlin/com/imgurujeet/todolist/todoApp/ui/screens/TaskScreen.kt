package com.imgurujeet.todolist.todoApp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.imgurujeet.todolist.todoApp.ui.components.CarouselCalendar
import com.imgurujeet.todolist.todoApp.ui.components.TopAppBar
import com.imgurujeet.todolist.todoApp.ui.navigation.bottomNavBar.BottomNavItems
import com.imgurujeet.todolist.todoApp.ui.theme.appColors

@Composable
fun TaskScreen(){
    TodoBackgroundScreen {
        Column(
            modifier = Modifier.fillMaxSize()
                .systemBarsPadding()
                .verticalScroll(rememberScrollState())
        ){
            TopAppBar("Today's task")
            CarouselCalendar()
        }



    }
}