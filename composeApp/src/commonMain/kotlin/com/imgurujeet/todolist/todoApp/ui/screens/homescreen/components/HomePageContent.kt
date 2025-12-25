package com.imgurujeet.todolist.todoApp.ui.screens.homescreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.imgurujeet.todolist.todoApp.data.model.InProgressTask
import com.imgurujeet.todolist.todoApp.data.model.TaskCategory
import com.imgurujeet.todolist.todoApp.data.model.TaskGroup
import com.imgurujeet.todolist.todoApp.data.model.TaskGroupCategory
import com.imgurujeet.todolist.todoApp.ui.screens.OnBoardingScreen
import com.imgurujeet.todolist.todoApp.ui.theme.Spacing
import com.imgurujeet.todolist.todoApp.ui.theme.TodoPreview
import com.imgurujeet.todolist.todoApp.ui.theme.appColors
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun HomePageContent(){
    val colors = MaterialTheme.appColors

    Column(
        modifier = Modifier.fillMaxSize()
            .systemBarsPadding()
            .verticalScroll(rememberScrollState())

    ) {
        Column(
            modifier = Modifier.padding(Spacing.s4)
        ) {
            UserHeader()
            Spacer(modifier = Modifier.size(Spacing.s6))
            TaskProgressCard()
            Spacer(modifier = Modifier.size(Spacing.s4))
            SectionHeader("In Progress")
        }
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            itemsIndexed(
                items = inProgressTasks,
                key = { _, task -> task.id}

            ){idx,task ->
                if(idx==0) Spacer(modifier = Modifier.size(Spacing.s4))
                InProgressTaskCard(task)
                if(idx == inProgressTasks.lastIndex){
                    Spacer(modifier = Modifier.size(Spacing.s4))
                }

            }

        }

        Column (
            modifier = Modifier.padding(Spacing.s4)
        ){
            SectionHeader("Task Groups",count = taskGroups.size)
            taskGroups.forEach { taskGroup ->
                TaskGroupCard(taskGroup)
                Spacer(modifier = Modifier.size(Spacing.s4))
            }
        }
        Spacer(modifier = Modifier.size(Spacing.s55))

    }

}


@Preview(showBackground = true)
@Composable
fun HomePageContentPreview(){
    TodoPreview(
    ){
        HomePageContent()
    }
}

@Preview(showBackground = true)
@Composable
fun HomePageContentDarkPreview(){
    TodoPreview(darkTheme = true) {
        HomePageContent()

    }
}


val taskGroups = listOf(
    TaskGroup("1", TaskGroupCategory.OfficeProject, 23, 70),
    TaskGroup("2", TaskGroupCategory.PersonalProject, 30, 52),
    TaskGroup("3", TaskGroupCategory.DailyStudy, 30, 87)
)

val inProgressTasks = listOf(
    InProgressTask("1", "Design meeting slides", TaskCategory.Office, 0.7f),
    InProgressTask("2", "Grocery shopping", TaskCategory.Personal, 0.4f),
    InProgressTask("3", "Revise Jetpack Compose notes", TaskCategory.Study, 0.9f),
    InProgressTask("4", "Miscellaneous chores", TaskCategory.Other, 0.3f)
)



@Preview(
    name = "Tablet",
    widthDp = 800,
    heightDp = 1280,
    showBackground = true
)
@Composable
fun TabletPreview() {
    TodoPreview {
        HomePageContent()
    }
}

@Preview(
    name = "Tablet • Dark",
    widthDp = 800,
    heightDp = 1280,
    showBackground = true
)
@Composable
fun TabletDarkPreview() {
    TodoPreview(darkTheme = true) {
        HomePageContent()
    }
}

@Preview(
    name = "Desktop",
    widthDp = 1440,
    heightDp = 900,
    showBackground = true
)
@Composable
fun DesktopPreview() {
    TodoPreview {
        HomePageContent()
    }
}
@Preview(
    name = "Desktop • Dark",
    widthDp = 1440,
    heightDp = 900,
    showBackground = true
)
@Composable
fun DesktopDarkPreview() {
    TodoPreview(darkTheme = true) {
        HomePageContent()
    }
}

