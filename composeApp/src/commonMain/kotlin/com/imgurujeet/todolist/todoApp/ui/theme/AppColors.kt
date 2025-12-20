package com.imgurujeet.todolist.todoApp.ui.theme

import androidx.compose.ui.graphics.Color


data class AppColors(
    val primary: Color,
    val secondary: Color,
    val success: Color,
    val dark: Color,
    val light: Color,
    val cream: Color,
    val softCyan: Color,
    val lightBlue: Color
)



val LightAppColors = AppColors(
    primary   = Color(0xFF007AFF),
    secondary = Color(0xFF6C5DD3),
    success   = Color(0xFF28A745),
    dark      = Color(0xFF222222),
    light     = Color(0xFFEAEAEA),
    cream     = Color(0xFFFFFEF0),
    softCyan  = Color(0xFFE8F5F0),
    lightBlue = Color(0xFFF0F8FF)
)

val DarkAppColors = AppColors(
    primary   = Color(0xFF4DA3FF), // softer blue
    secondary = Color(0xFF9A8CFF), // lighter violet
    success   = Color(0xFF5CD68D), // readable green
    dark      = Color(0xFF0F0F0F), // true dark bg
    light     = Color(0xFF2A2A2A), // surface
    cream     = Color(0xFF1A1A14), // warm dark
    softCyan  = Color(0xFF141F1D), // muted cyan
    lightBlue = Color(0xFF0E151C)  // deep blue-gray
)
