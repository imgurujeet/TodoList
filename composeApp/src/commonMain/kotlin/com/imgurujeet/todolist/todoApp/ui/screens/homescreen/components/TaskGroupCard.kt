package com.imgurujeet.todolist.todoApp.ui.screens.homescreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.imgurujeet.todolist.todoApp.data.model.TaskGroup
import com.imgurujeet.todolist.todoApp.data.model.TaskGroupCategory
import com.imgurujeet.todolist.todoApp.data.model.backgroundColor
import com.imgurujeet.todolist.todoApp.data.model.iconColor
import com.imgurujeet.todolist.todoApp.ui.theme.BodyLarge
import com.imgurujeet.todolist.todoApp.ui.theme.BodySmall
import com.imgurujeet.todolist.todoApp.ui.theme.Spacing
import com.imgurujeet.todolist.todoApp.ui.theme.TodoPreview
import com.imgurujeet.todolist.todoApp.ui.theme.appColors
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun TaskGroupCard(
    taskGroup : TaskGroup= TaskGroup(
        id = "1",
        category = TaskGroupCategory.OfficeProject,
        taskCount = 5,
        completionPercentage = 80
    ),
){

    Card(
        modifier = Modifier.fillMaxWidth()
            .clip(RoundedCornerShape(Spacing.s4))
            .padding(vertical = Spacing.s2),
        colors = CardDefaults.cardColors(
            containerColor = taskGroup.category.backgroundColor().copy(alpha = 0.15f),
        )
    ){
        Row (
            modifier = Modifier.fillMaxWidth()
                .padding(Spacing.s4),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically,
            ){
                Box(
                    modifier = Modifier.size(Spacing.s8)
                        .background(
                            color = taskGroup.category.iconColor().copy(alpha = 0.2f),
                            shape = CircleShape
                        ),
                    contentAlignment = Alignment.Center

                ){
                    Icon(
                        imageVector = taskGroup.category.icon,
                        contentDescription = taskGroup.category.displayName,
                        tint = taskGroup.category.iconColor(),
                        modifier = Modifier.size(Spacing.s4)

                    )

                }

                Spacer(Modifier.size(Spacing.s4))

                Column {
                    Text(
                        text = taskGroup.category.displayName,
                        style = BodyLarge().copy(
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onSurface

                        )


                    )
                    Spacer(Modifier.size(Spacing.s1))
                    Text(
                        text = "${taskGroup.taskCount} Tasks",
                        style = BodySmall().copy(
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
                        )
                    )

                }



            }

            Box(
                modifier = Modifier.size(Spacing.s13),
                contentAlignment = Alignment.Center

            ){
                CircularProgressIndicator(
                    progress = taskGroup.completionPercentage /100f,
                    modifier = Modifier.size(Spacing.s18),
                    strokeWidth = 6.dp,
                    color = taskGroup.category.iconColor(),
                    trackColor = taskGroup.category.iconColor().copy(alpha = 0.2f)
                )
                Text(
                    text = "${(taskGroup.completionPercentage)}%",
                    style = BodySmall().copy(
                        fontSize = 14.sp ,
                        fontWeight = FontWeight.SemiBold,
                        color = taskGroup.category.iconColor()
                    )
                )

            }

        }
    }


}

@Preview(showBackground = true)
@Composable
fun TaskGroupCardPreview(){
    TodoPreview {
        TaskGroupCard()
    }
}


@Preview(showBackground = true, backgroundColor = 0xFF222222)
@Composable
fun TaskGroupCardDarkPreview(){
    TodoPreview(darkTheme = true) {
        TaskGroupCard()
    }
}