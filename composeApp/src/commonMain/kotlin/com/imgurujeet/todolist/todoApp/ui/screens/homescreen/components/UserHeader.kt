package com.imgurujeet.todolist.todoApp.ui.screens.homescreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.imgurujeet.todolist.todoApp.ui.theme.Spacing
import com.imgurujeet.todolist.todoApp.ui.theme.TodoPreview
import com.imgurujeet.todolist.todoApp.ui.theme.appColors
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import todolist.composeapp.generated.resources.Res
import todolist.composeapp.generated.resources.notification


@Composable
fun UserHeader(){
    val shouldShowNotificationDot by remember { mutableStateOf(true) }

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically,
        ){
            Box(
                modifier = Modifier.size(Spacing.s14)
                    .clip(CircleShape)
                    .background(
                        MaterialTheme.appColors.primary
                    ),
                Alignment.Center
            ) {

                Text(
                    text = "U",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.appColors.light
                )

            }
            Column (
                modifier = Modifier.padding(start = Spacing.s2),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ){
                Text(
                    text = "Hello!",
                    style = MaterialTheme.typography.titleSmall )

                Text(
                    text = "User Name",
                    style = MaterialTheme.typography.titleMedium )
            }

        }
        Box(
            modifier = Modifier.size(Spacing.s6)

        ){
            Icon(
                painter = painterResource(Res.drawable.notification),
                contentDescription = null,
                modifier = Modifier.size(Spacing.s14),
                tint = MaterialTheme.colorScheme.onBackground
            )
            if(shouldShowNotificationDot){
                Box(
                    modifier = Modifier.offset(x = -Spacing.s1).size(Spacing.s2)
                        .background(
                            MaterialTheme.appColors.primary,
                        CircleShape
                    ).align(Alignment.TopEnd).padding(Spacing.s1),

                    )
            }


        }


    }
}


@Preview(name = "Light", showBackground = true)
@Composable
fun TodoBackgroundLightPreview() {
    TodoPreview {
        UserHeader()
    }
}

@Preview(name = "Dark", showBackground = true)
@Composable
fun TodoBackgroundDarkPreview() {
    TodoPreview(darkTheme = true) {
        UserHeader()
    }
}