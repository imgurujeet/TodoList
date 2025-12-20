package com.imgurujeet.todolist.todoApp.ui.theme

import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun TodoPreview(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    TodoAppTheme(darkTheme = darkTheme) {
        content()
    }
}
