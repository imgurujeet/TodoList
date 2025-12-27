package com.imgurujeet.todolist.todoApp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.imgurujeet.todolist.todoApp.ui.navigation.NavRoute
import com.imgurujeet.todolist.todoApp.ui.theme.appColors

@Composable
fun NotesScreen(){
    TodoBackgroundScreen {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Text(
                "You're inside notes screen",
                color = MaterialTheme.appColors.onBackground
            )
        }
    }
}