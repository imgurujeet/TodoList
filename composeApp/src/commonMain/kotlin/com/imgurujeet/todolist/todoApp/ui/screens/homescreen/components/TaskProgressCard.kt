package com.imgurujeet.todolist.todoApp.ui.screens.homescreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.imgurujeet.todolist.todoApp.ui.components.CurvedButton
import com.imgurujeet.todolist.todoApp.ui.components.CurvedButtonConfig
import com.imgurujeet.todolist.todoApp.ui.theme.BodyXLarge
import com.imgurujeet.todolist.todoApp.ui.theme.Spacing
import com.imgurujeet.todolist.todoApp.ui.theme.TodoPreview
import com.imgurujeet.todolist.todoApp.ui.theme.appColors
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun TaskProgressCard(){
    Box(
        modifier = Modifier.fillMaxWidth()
            .clip(RoundedCornerShape(Spacing.s6))
            .background(MaterialTheme.appColors.primary)
            .padding(Spacing.s6)
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f),
            ) {
                Text(
                    "Your Tasks Progress",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.White

                )
                Spacer(modifier = Modifier.height(Spacing.s6))

                CurvedButton(
                    onClick = { /*TODO*/ },
                    text = "View Task",
                    buttonConfig = CurvedButtonConfig(
                        cornerRadius = 40f,
                        verticalBulgeFactor = 10f,
                        containerColor =  MaterialTheme.appColors.light,
                        contentColor = MaterialTheme.appColors.primary,
                        shouldShowArrow = true

                    )
                )

            }

            Spacer(modifier = Modifier.width(Spacing.s6))

            Box(
                modifier = Modifier.size(Spacing.s25),
                contentAlignment = Alignment.Center
            ){
                CircularProgressIndicator(
                    progress = {0.8f},
                    modifier = Modifier.size(Spacing.s25),
                    trackColor = MaterialTheme.appColors.light.copy(alpha = 0.2f),
                    color = MaterialTheme.appColors.light,
                    strokeWidth = Spacing.s2
                )
                Text(
                    text = "80%",
                    style = BodyXLarge().copy(
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.appColors.light
                    ),
                )


            }


        }


    }

}


@Preview(name = "Light", showBackground = true)
@Composable
fun TodoProgressCardPreviewLight() {
    TodoPreview {
        TaskProgressCard()
    }
}

@Preview(name = "Dark", showBackground = true)
@Composable
fun TodoProgressCardPreview() {
    TodoPreview(darkTheme = true) {
        TaskProgressCard()
    }
}