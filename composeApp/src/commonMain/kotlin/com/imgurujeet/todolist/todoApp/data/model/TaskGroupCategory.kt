package com.imgurujeet.todolist.todoApp.data.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.imgurujeet.todolist.todoApp.ui.theme.appColors

enum class TaskGroupCategory (
    val displayName: String,
    val icon: ImageVector
){
    OfficeProject(
        displayName = "Office",
        icon = Icons.Default.Work
    ),
    PersonalProject(
        displayName = "Personal",
        icon = Icons.Default.Person
    ),
    DailyStudy(
        displayName = "Daily Study",
        icon = Icons.Default.Book
    ),
    Other(
        displayName = "Other",
        icon= Icons.Default.List
    )
}


@Composable
fun TaskGroupCategory.backgroundColor(): Color {
    return when (this) {
        TaskGroupCategory.OfficeProject -> MaterialTheme.appColors.cardOffice.copy(alpha = 0.2f)
        TaskGroupCategory.PersonalProject -> MaterialTheme.appColors.cardPersonal.copy(alpha = 0.2f)
        TaskGroupCategory.DailyStudy -> MaterialTheme.appColors.cardStudy.copy(alpha = 0.2f)
        TaskGroupCategory.Other -> MaterialTheme.appColors.cardOther.copy(alpha = 0.2f)

    }

}

@Composable
fun TaskGroupCategory.progressColor(): Color {
    return when (this) {
        TaskGroupCategory.OfficeProject -> MaterialTheme.appColors.cardOffice
        TaskGroupCategory.PersonalProject -> MaterialTheme.appColors.cardPersonal
        TaskGroupCategory.DailyStudy -> MaterialTheme.appColors.cardStudy
        TaskGroupCategory.Other -> MaterialTheme.appColors.cardOther
    }
}

@Composable
fun TaskGroupCategory.iconColor(): Color {
    return when (this) {
        TaskGroupCategory.OfficeProject -> MaterialTheme.appColors.cardOffice
        TaskGroupCategory.PersonalProject -> MaterialTheme.appColors.cardPersonal
        TaskGroupCategory.DailyStudy -> MaterialTheme.appColors.cardStudy
        TaskGroupCategory.Other -> MaterialTheme.appColors.cardOther

    }
}