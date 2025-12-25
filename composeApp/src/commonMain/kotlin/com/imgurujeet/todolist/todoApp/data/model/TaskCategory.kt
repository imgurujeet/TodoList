package com.imgurujeet.todolist.todoApp.data.model

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.imgurujeet.todolist.todoApp.ui.theme.appColors

enum class TaskCategory (
    val displayName: String,
){
    Office(
        displayName = "Office",

    ),
    Personal(
        displayName = "Personal",


    ),
    Study(
        displayName = "Study",


    ),
    Other(
        displayName = "Other",

    )

}




@Composable
fun TaskCategory.backgroundColor(): Color {
    return when (this) {
        TaskCategory.Office -> MaterialTheme.appColors.cardOffice.copy(alpha = 0.2f)
        TaskCategory.Personal -> MaterialTheme.appColors.cardPersonal.copy(alpha = 0.2f)
        TaskCategory.Study -> MaterialTheme.appColors.cardStudy.copy(alpha = 0.2f)
        TaskCategory.Other -> MaterialTheme.appColors.cardOther.copy(alpha = 0.2f)
    }
}

@Composable
fun TaskCategory.progressColor(): Color {
    return when (this) {
        TaskCategory.Office -> MaterialTheme.appColors.cardOffice
        TaskCategory.Personal -> MaterialTheme.appColors.cardPersonal
        TaskCategory.Study -> MaterialTheme.appColors.cardStudy
        TaskCategory.Other -> MaterialTheme.appColors.cardOther
    }
}
