package com.imgurujeet.todolist.todoApp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.imgurujeet.todolist.todoApp.data.model.ScheduleTaskModel
import com.imgurujeet.todolist.todoApp.data.model.backgroundColor
import com.imgurujeet.todolist.todoApp.data.model.iconColor
import com.imgurujeet.todolist.todoApp.ui.theme.BodyLarge
import com.imgurujeet.todolist.todoApp.ui.theme.BodyNormal
import com.imgurujeet.todolist.todoApp.ui.theme.BodySmall
import com.imgurujeet.todolist.todoApp.ui.theme.BodyXSmall
import com.imgurujeet.todolist.todoApp.ui.theme.Spacing
import com.imgurujeet.todolist.todoApp.ui.theme.TodoPreview
import com.imgurujeet.todolist.todoApp.ui.theme.appColors
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import todolist.composeapp.generated.resources.Res
import todolist.composeapp.generated.resources.pie_chart
import todolist.composeapp.generated.resources.time_icon

@Composable
fun ScheduledTaskCard(task: ScheduleTaskModel = ScheduleTaskModel()) {

    val category = task.category

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = Spacing.s2)
            .shadow(
                elevation = 6.dp,
                shape = RoundedCornerShape(Spacing.s4),
                ambientColor = Color.Black.copy(alpha = 0.05f),
                spotColor = Color.Black.copy(alpha = 0.12f)
            )
            .clip(RoundedCornerShape(Spacing.s4))
            .background(category.backgroundColor())
            .padding(Spacing.s4)
    ) {

        Box(
            modifier = Modifier
                .size(Spacing.s8)
                .align(Alignment.TopEnd)
                .background(
                    color = category.iconColor().copy(alpha = 0.2f),
                    shape = RoundedCornerShape(16.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = category.icon,
                contentDescription = category.displayName,
                tint = category.iconColor(),
                modifier = Modifier.size(Spacing.s5)
            )
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(Spacing.s2)
        ) {
            // ---------- TOP ROW (Title + Icon) ----------
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = task.title,
                    style = BodySmall().copy(
                        color = MaterialTheme.appColors.secondary                    )
                )
            }

            // ---------- DESCRIPTION ----------
            Text(
                modifier = Modifier.align (Alignment.Start).padding(end = Spacing.s20),
                text = task.description,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = BodyLarge().copy(
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.appColors.onSurface
                )
            )


            // ---------- BOTTOM ROW (Time + Done Chip) ----------
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                TimeComp("10:00 AM")
            }
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .background(
                    color = MaterialTheme.appColors.primary.copy(alpha = 0.2f),
                    shape = RoundedCornerShape(
                        topStart = Spacing.s2,
                        bottomEnd = Spacing.s2
                    )
                ).padding(Spacing.s1),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Done",
                style = BodyXSmall().copy(color = MaterialTheme.appColors.primary)
            )
        }
    }
}

@Composable
fun TimeComp(time : String) {
    Row(
        modifier = Modifier,
        horizontalArrangement = Arrangement.spacedBy(Spacing.s1),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier.size(Spacing.s5),
            painter = painterResource(Res.drawable.time_icon),
            contentDescription = "",
            colorFilter = ColorFilter.tint(MaterialTheme.appColors.onSurface)
        )

        Text(
            time,
            style = BodyNormal().copy(
                color = MaterialTheme.appColors.onSurface
            )
        )

    }
}


@Preview(showBackground = true)
@Composable
fun ScheduledTaskCardPreview() {
    TodoPreview {
        ScheduledTaskCard()
    }
}


