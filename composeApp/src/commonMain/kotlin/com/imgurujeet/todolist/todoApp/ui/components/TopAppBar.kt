package com.imgurujeet.todolist.todoApp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.text.font.FontWeight
import com.imgurujeet.todolist.todoApp.ui.theme.Spacing
import com.imgurujeet.todolist.todoApp.ui.theme.TodoPreview
import com.imgurujeet.todolist.todoApp.ui.theme.appColors
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import todolist.composeapp.generated.resources.Res
import todolist.composeapp.generated.resources.arrow_left
import todolist.composeapp.generated.resources.notification


@Composable
fun TopAppBar(
    title : String,
    onClick : () -> Unit = {}

)
{
    val colors = MaterialTheme.appColors
    val shouldShowNotificationDot by remember { mutableStateOf(true) }
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            painter = painterResource(Res.drawable.arrow_left),
            contentDescription = null,
            tint = colors.onBackground,
            modifier = Modifier.clickable(
                onClick = onClick
            )
        )
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.SemiBold,
            color = colors.onBackground
        )
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

@Preview(showBackground = true)
@Composable
fun TopAppbarPreview(){
    TodoPreview {
        TopAppBar( "Today's Task")

    }
}