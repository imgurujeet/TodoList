package com.imgurujeet.todolist.todoApp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.imgurujeet.todolist.todoApp.data.model.ScheduleTaskModel
import com.imgurujeet.todolist.todoApp.ui.components.CarouselCalendar
import com.imgurujeet.todolist.todoApp.ui.components.CurvedButton
import com.imgurujeet.todolist.todoApp.ui.components.CurvedButtonConfig
import com.imgurujeet.todolist.todoApp.ui.components.ScheduledTaskCard
import com.imgurujeet.todolist.todoApp.ui.components.TopAppBar
import com.imgurujeet.todolist.todoApp.ui.navigation.bottomNavBar.BottomNavItems
import com.imgurujeet.todolist.todoApp.ui.screens.homescreen.components.SectionHeader
import com.imgurujeet.todolist.todoApp.ui.screens.homescreen.components.TaskProgressCard
import com.imgurujeet.todolist.todoApp.ui.screens.homescreen.components.UserHeader
import com.imgurujeet.todolist.todoApp.ui.theme.Spacing
import com.imgurujeet.todolist.todoApp.ui.theme.appColors

@Composable
fun TaskScreen(){

    val selected = remember { mutableStateOf("All") }

    val chips = listOf<String>(
        "All",
        "To-do",
        "Ongoing",
        "Done"
    )

    val scheduleCards = List(5) { ScheduleTaskModel() }
    TodoBackgroundScreen {
        BoxWithConstraints(
            modifier = Modifier.fillMaxSize()
                .systemBarsPadding()
        ){

            val isWideScreen = maxWidth >= 600.dp

            if (isWideScreen){
                Row(
                    modifier = Modifier.padding(Spacing.s4)
                ) {
                    //TopAppBar("Today's task")
                   Column(
                       modifier = Modifier.weight(1f)
                           .padding(end = Spacing.s4)

                   ){
                       Row(
                           modifier = Modifier.fillMaxWidth(),
                           verticalAlignment = Alignment.CenterVertically,
                           horizontalArrangement = Arrangement.SpaceBetween,

                       ){
                           Text(
                               "Today's task",
                               style = MaterialTheme.typography.titleLarge,
                               color = MaterialTheme.appColors.onBackground
                           )

                           LazyRow(
                              // modifier = Modifier.fillMaxWidth(),
                               horizontalArrangement = Arrangement.spacedBy(12.dp)
                           ){
                               itemsIndexed(chips){ idx , title ->
                                   val curr = chips[idx]
                                   if(idx == 0) Spacer(modifier = Modifier.size(Spacing.s4))

                                   CurvedButton(
                                       modifier = Modifier.width(width = 100.dp).height(40.dp),
                                       text = title,
                                       buttonConfig = CurvedButtonConfig(
                                           containerColor = if(selected.value == title) MaterialTheme.appColors.primary
                                           else MaterialTheme.appColors.light,
                                           contentColor = if(selected.value == title) MaterialTheme.appColors.onBackground
                                           else MaterialTheme.appColors.onBackground.copy(0.8f),
                                           fontSize = 14.sp,
                                           verticalBulgeFactor = 8f,
                                           cornerRadius = 28f,
                                           shouldShowArrow = false,
                                           gradientShadowColor = Color.Transparent

                                       ),
                                       isEnabled = true

                                   ){
                                       selected.value = curr

                                   }

                                   if (idx == chips.lastIndex) {
                                       Spacer(modifier = Modifier.size(Spacing.s4))
                                   }


                               }

                           }
                       }


                       Spacer(modifier = Modifier.size(Spacing.s4))

                       LazyColumn(
                           modifier = Modifier.fillMaxWidth()

                       ){

                           items(scheduleCards.size) { idx ->

                               ScheduledTaskCard()
                               if (idx==(scheduleCards.lastIndex)) {
                                   Spacer(modifier = Modifier.size(Spacing.s55))
                               }

                           }




                       }

                   }



                    CarouselCalendar(
                        maxWidth = this@BoxWithConstraints.maxWidth,
                        maxHeight = this@BoxWithConstraints.maxHeight
                    )


                }
            } else {
                Column(
                    modifier = Modifier.padding(Spacing.s4)
                ) {
                    TopAppBar("Today's task")
                    CarouselCalendar(
                        maxWidth = this@BoxWithConstraints.maxWidth,
                        maxHeight = this@BoxWithConstraints.maxHeight
                    )

                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ){
                        itemsIndexed(chips){ idx , title ->
                            val curr = chips[idx]
                            if(idx == 0) Spacer(modifier = Modifier.size(Spacing.s4))

                            CurvedButton(
                                modifier = Modifier.width(width = 100.dp).height(40.dp),
                                text = title,
                                buttonConfig = CurvedButtonConfig(
                                    containerColor = if(selected.value == title) MaterialTheme.appColors.primary
                                    else MaterialTheme.appColors.light,
                                    contentColor = if(selected.value == title) MaterialTheme.appColors.onBackground
                                    else MaterialTheme.appColors.onBackground.copy(0.8f),
                                    fontSize = 14.sp,
                                    verticalBulgeFactor = 8f,
                                    cornerRadius = 28f,
                                    shouldShowArrow = false,
                                    gradientShadowColor = Color.Transparent

                                ),
                                isEnabled = true

                            ){
                                selected.value = curr

                            }

                            if (idx == chips.lastIndex) {
                                Spacer(modifier = Modifier.size(Spacing.s4))
                            }


                        }

                    }
                    Spacer(modifier = Modifier.size(Spacing.s4))

                    LazyColumn(
                        modifier = Modifier.fillMaxWidth()

                    ){

                        items(scheduleCards.size) { idx ->

                            ScheduledTaskCard()
                            if (idx==(scheduleCards.lastIndex)) {
                                Spacer(modifier = Modifier.size(Spacing.s55))
                            }

                        }




                    }


                }
            }



        }



    }
}