package com.imgurujeet.todolist.todoApp.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.material3.MaterialTheme

val MaterialTheme.appColors: AppColors
    @Composable
    get() = LocalAppColors.current
