package com.imgurujeet.todolist.todoApp.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.Font
import todolist.composeapp.generated.resources.Manrope_Bold
import todolist.composeapp.generated.resources.Manrope_ExtraBold
import todolist.composeapp.generated.resources.Manrope_ExtraLight
import todolist.composeapp.generated.resources.Manrope_Light
import todolist.composeapp.generated.resources.Manrope_Medium
import todolist.composeapp.generated.resources.Manrope_Regular
import todolist.composeapp.generated.resources.Manrope_SemiBold
import todolist.composeapp.generated.resources.Res


@Composable
fun manropeFamilyFont()= FontFamily(
    Font(Res.font.Manrope_Regular, FontWeight.Normal),
    Font(Res.font.Manrope_Medium, FontWeight.Medium),
    Font(Res.font.Manrope_SemiBold, FontWeight.SemiBold),
    Font(Res.font.Manrope_Bold, FontWeight.Bold),
    Font(Res.font.Manrope_ExtraBold, FontWeight.Black),
    Font(Res.font.Manrope_Light, FontWeight.Light),
    Font(Res.font.Manrope_ExtraLight, FontWeight.ExtraLight)

)