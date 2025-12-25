package com.imgurujeet.todolist.todoApp.ui.theme

import androidx.compose.ui.graphics.Color


data class AppColors(
    val primary: Color,
    val secondary: Color,
    val success: Color,

    // existing
    val dark: Color,
    val light: Color,
    val cream: Color,
    val softCyan: Color,
    val lightBlue: Color,

    val countColor: Color,

    // 🔥 NEW – semantic extensions (safe additions)
    val background: Color,
    val surface: Color,
    val onBackground: Color,
    val onSurface: Color,
    val onSoftCyan: Color,
    val divider: Color,

    // 🔥 Category card colors
    val cardOffice: Color,
    val cardPersonal: Color,
    val cardStudy: Color,
    val cardOther: Color,
    val cardUrgent: Color
)




val LightAppColors = AppColors(
    primary   = Color(0xFF007AFF),
    secondary = Color(0xFF6C5DD3),
    success   = Color(0xFF28A745),

    dark      = Color(0xFF222222),
    light     = Color(0xFFEAEAEA),
    cream     = Color(0xFFFFFEF0),
    softCyan  = Color(0xFFE8F5F0),
    lightBlue = Color(0xFFF0F8FF),

    countColor = Color(0xFF4D5C6C),

    // 🔥 Extended semantics
    background   = Color(0xFFFFFEF0),   // cream base
    surface      = Color(0xFFFFFFFF),
    onBackground = Color(0xFF1C1C1C),
    onSurface    = Color(0xFF222222),
    onSoftCyan   = Color(0xFF0F3D36),
    divider      = Color(0xFFE0E0E0),
    // Light theme – category cards
    cardOffice   = Color(0xFF2F80ED), // strong blue
    cardPersonal = Color(0xFFD63384), // rich pink
    cardStudy    = Color(0xFF2E7D32), // deep green
    cardOther    = Color(0xFFF2994A), // warm amber
    cardUrgent   = Color(0xFFEB5757)  // strong red

)


val DarkAppColors = AppColors(
    primary   = Color(0xFF4DA3FF),
    secondary = Color(0xFF9A8CFF),
    success   = Color(0xFF5CD68D),

    dark      = Color(0xFF0F0F0F),
    light     = Color(0xFF2A2A2A),
    cream     = Color(0xFF1A1A14),
    softCyan  = Color(0xFF141F1D),
    lightBlue = Color(0xFF0E151C),

    countColor = Color(0xFF4DA3FF),

    // 🔥 Extended semantics
    background   = Color(0xFF0F1214),
    surface      = Color(0xFF161A1D),
    onBackground = Color(0xFFE6EAEA),
    onSurface    = Color(0xFFDDE3E3),
    onSoftCyan   = Color(0xFFBFEAE0),
    divider      = Color(0xFF2A3236),

    // Dark theme – category cards
    cardOffice   = Color(0xFF6AA9FF), // luminous blue
    cardPersonal = Color(0xFFFF7AB6), // soft neon pink
    cardStudy    = Color(0xFF6FCF97), // mint green
    cardOther    = Color(0xFFF2C94C), // golden yellow
    cardUrgent   = Color(0xFFFF6B6B)  // coral red

)

