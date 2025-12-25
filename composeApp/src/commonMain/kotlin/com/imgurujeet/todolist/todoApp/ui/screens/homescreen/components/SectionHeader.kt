package com.imgurujeet.todolist.todoApp.ui.screens.homescreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.imgurujeet.todolist.todoApp.ui.theme.BodySmall
import com.imgurujeet.todolist.todoApp.ui.theme.BodyXXLarge
import com.imgurujeet.todolist.todoApp.ui.theme.Spacing
import com.imgurujeet.todolist.todoApp.ui.theme.TodoPreview
import com.imgurujeet.todolist.todoApp.ui.theme.appColors
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun SectionHeader(title: String, count: Int?=null){
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(vertical = Spacing.s4),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Text(
            title,
            style = BodyXXLarge().copy(
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
        )
        if(count != null){
            Spacer(modifier = Modifier.width(Spacing.s2))
            Box(
               modifier = Modifier.size(Spacing.s5)
                   .background(
                       color = MaterialTheme.appColors.softCyan.copy(alpha = 0.3f),
                       shape = RoundedCornerShape(Spacing.s5)
                   )
                   .padding(Spacing.sHalf),
                contentAlignment = Alignment.Center

            ){
                Text(
                    count.toString(),
                    style = BodySmall().copy(
                        color = MaterialTheme.colorScheme.onBackground
                    )
                )
            }

        }

    }


}




@Preview(showBackground = true)
@Composable
fun SectionHeaderPreview(){
    TodoPreview(darkTheme = true) {
        SectionHeader("In Progress",4)
    }
}

@Preview(showBackground = true)
@Composable
fun SectionHeaderPreviewDark(){
    TodoPreview(darkTheme = true) {
    SectionHeader("In Progress", 4)
    }
}

