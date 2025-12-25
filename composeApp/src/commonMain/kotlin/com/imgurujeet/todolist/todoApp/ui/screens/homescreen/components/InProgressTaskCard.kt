package com.imgurujeet.todolist.todoApp.ui.screens.homescreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.imgurujeet.todolist.todoApp.data.model.InProgressTask
import com.imgurujeet.todolist.todoApp.data.model.TaskCategory
import com.imgurujeet.todolist.todoApp.data.model.backgroundColor
import com.imgurujeet.todolist.todoApp.data.model.progressColor
import com.imgurujeet.todolist.todoApp.ui.theme.BodyLarge
import com.imgurujeet.todolist.todoApp.ui.theme.BodySmall
import com.imgurujeet.todolist.todoApp.ui.theme.Spacing
import com.imgurujeet.todolist.todoApp.ui.theme.TodoPreview
import com.imgurujeet.todolist.todoApp.ui.theme.appColors
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
fun InProgressTaskCard(task: InProgressTask = InProgressTask(
    id = "1",
    title = "Doing First KMP Project",
    category = TaskCategory.Office,
    progressPercentage = 0.8f,
    )
){
    Box(
        modifier = Modifier.height(Spacing.s30)
            .width(Spacing.s55)
            .background(
                color = task.category.backgroundColor(),
                shape = RoundedCornerShape(Spacing.s4)
            )
            .padding(Spacing.s4),

    ){
        Column(
            modifier = Modifier.fillMaxWidth()
        ){
            Text(
                text = task.category.displayName,
                style = BodySmall().copy(
                    color = MaterialTheme.colorScheme.onSurface

                )
            )
            Spacer(modifier = Modifier.height(Spacing.s2))
            Text(
                text = task.title,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = BodyLarge().copy(
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start,
                    color = MaterialTheme.colorScheme.onSurface
                )
            )
            Spacer(modifier = Modifier.height(Spacing.s3))

            LinearProgressIndicator(
                modifier = Modifier.fillMaxWidth(),
                progress = task.progressPercentage,
                color = task.category.progressColor(),
            )



        }

    }




}

@Preview(showBackground = true)
@Composable
fun InProgressTaskCardPreview(){
    TodoPreview {
        InProgressTaskCard()
    }
}

@Preview(showBackground = true, backgroundColor =0xFF222222 )
@Composable
fun InProgressTaskCardPreviewDark(){
    TodoPreview(darkTheme = true) {
        InProgressTaskCard()
    }
}