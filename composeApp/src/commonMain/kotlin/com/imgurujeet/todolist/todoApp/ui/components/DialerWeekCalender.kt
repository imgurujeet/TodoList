package com.imgurujeet.todolist.todoApp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.imgurujeet.todolist.todoApp.ui.theme.BodySmall
import com.imgurujeet.todolist.todoApp.ui.theme.H3TextStyle
import com.imgurujeet.todolist.todoApp.ui.theme.Spacing
import com.imgurujeet.todolist.todoApp.ui.theme.TodoPreview
import com.imgurujeet.todolist.todoApp.ui.theme.appColors
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.plus
import kotlinx.datetime.toLocalDateTime
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlin.math.abs
import kotlin.time.Clock
import kotlin.time.ExperimentalTime


@OptIn(ExperimentalTime::class)
@Composable
fun CarouselCalendar(
    initialSelectedDate: LocalDate? = null,
    onDateSelected: (LocalDate) -> Unit = {},
    maxWidth: Dp,
    maxHeight: Dp
) {
    //// Clock.System.now() -> Output: 2025-11-15T14:30:45.123456789Z
    ////                        (Year-Month-Day T Hour:Minute:Second.Nanoseconds Z for UTC)


    //// Output: 2025-11-15T20:00:45.123456789 (if you're in IST, UTC+5:30)
    val today = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date

    // Output: 2025-11-15

    val year = today.year // 2025

    // Always start from 1st January
    val startDate = LocalDate(year, 1, 1)
    val endDate = LocalDate(year, 12, 31)

    // Generate full year date list
    val dates = remember {
        generateSequence(startDate) { date ->
            val next = date.plus(1, DateTimeUnit.DAY)
            if (next <= endDate) next else null
        }.toList()
    }

    // Selected item is today's date (even though list starts at Jan 1)
    var selectedDate by remember { mutableStateOf(initialSelectedDate ?: today) }


        DialerWeekCalendar(
            dates = dates,
            selectedDate = selectedDate,
            onDateSelected = {
                selectedDate = it
                onDateSelected(it)
            },
            maxWidth = maxWidth, maxHeight = maxHeight
        )

}
@Composable
fun DialerWeekCalendar(
    modifier: Modifier = Modifier,
    dates: List<LocalDate>,
    selectedDate: LocalDate,
    onDateSelected: (LocalDate) -> Unit,
    maxWidth: Dp,
    maxHeight: Dp
) {
    /*
    * The LazyListState is used here because the calendar uses a LazyRow (line 106), which is a lazy composable that only renders visible items.

        rememberLazyListState() provides:
        Scroll position tracking: Monitors which items are currently visible in the viewport
        Layout information: Access to layoutInfo
        * dimensions and visible item positions—essential for calculating the 3D rotation and scaling effects based on each item's distance from center
        Scroll control: Enables scrollToItem() and animateScrollToItem() to programmatically center the selected date
        Without it, we wouldn't be able to detect item positions or programmatically scroll to the selected date.
    *
    * */
    val listState = rememberLazyListState()
    var isInitialLoad by remember { mutableStateOf(true) }

    // Auto-scroll to center the selected date
    LaunchedEffect(selectedDate) {
        val selectedIndex = dates.indexOf(selectedDate)
        if (selectedIndex != -1) {
            if (isInitialLoad) {
                listState.scrollToItem(index = selectedIndex)
                isInitialLoad = false
            } else {
                // Animate scroll for subsequent selections
                listState.animateScrollToItem(index = selectedIndex)
            }
        }
    }


    val isWideScreen = maxWidth >= 600.dp

    if (!isWideScreen){
        LazyRow(
            modifier = modifier
                .fillMaxWidth()
                .height(Spacing.s30),
            state = listState,
            horizontalArrangement = Arrangement.spacedBy(Spacing.s3),
            verticalAlignment = Alignment.CenterVertically,
            contentPadding = PaddingValues(horizontal = (maxWidth / 2) - 46.dp)
        ) {
            items(dates.size) { index ->
                val date = dates[index]

                // Calculate the center position dynamically
                val layoutInfo = listState.layoutInfo
                val viewportCenter = layoutInfo.viewportStartOffset + (layoutInfo.viewportEndOffset - layoutInfo.viewportStartOffset) / 2

                val itemInfo = layoutInfo.visibleItemsInfo.find { it.index == index }
                val itemCenter = itemInfo?.let { it.offset + it.size / 2 } ?: 0

                // Calculate distance from center
                val distanceFromCenter = if (itemInfo != null) {
                    abs(viewportCenter - itemCenter).toFloat() / layoutInfo.viewportSize.width
                } else {
                    1f
                }

                val scale = (1f - (distanceFromCenter * 0.3f)).coerceIn(0.7f, 1f)
                val rotationY = (distanceFromCenter * 40f).coerceAtMost(45f)
                val alpha = (1f - (distanceFromCenter * 0.5f)).coerceIn(0.5f, 1f)

                Box(
                    modifier = Modifier
                        .graphicsLayer {
                            scaleX = scale
                            scaleY = scale
                            this.rotationY = if (itemCenter < viewportCenter) rotationY else -rotationY
                            this.alpha = alpha
                        }

                        .clip(RoundedCornerShape(Spacing.s4))
                        .background(
                            if (date == selectedDate) MaterialTheme.appColors.primary
                            else MaterialTheme.appColors.light
                        )
                        .clickable {
                            onDateSelected(date)
                        }
                        .width(Spacing.s20)
                        .height(Spacing.s25),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = date.month.name.take(3),
                            style = BodySmall().copy(
                                color = if (date == selectedDate) Color.White.copy(alpha = 0.8f)
                                else MaterialTheme.appColors.onSurface
                            )
                        )
                        Spacer(Modifier.size(Spacing.s1))
                        Text(
                            text = date.day.toString(),
                            style = H3TextStyle().copy(
                                fontWeight = FontWeight.Bold,
                                color = if (date == selectedDate) Color.White else MaterialTheme.appColors.onSurface
                            ),
                        )
                        Spacer(Modifier.size(Spacing.s1))
                        Text(
                            text = date.dayOfWeek.name.take(3),
                            style = BodySmall().copy(
                                color = if (date == selectedDate) Color.White.copy(alpha = 0.8f)
                                else MaterialTheme.appColors.onSurface
                            ),
                        )
                    }
                }
            }
        }
    }else{
        LazyColumn(
            modifier = modifier
                .fillMaxHeight()
                .height(Spacing.s30),
            state = listState,
            verticalArrangement = Arrangement.spacedBy(Spacing.s3),
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = PaddingValues(vertical = (maxHeight / 2) - 46.dp)
        ) {
            items(dates.size) { index ->
                val date = dates[index]

                // Calculate the center position dynamically
                val layoutInfo = listState.layoutInfo
                val viewportCenter = layoutInfo.viewportStartOffset + (layoutInfo.viewportEndOffset - layoutInfo.viewportStartOffset) / 2

                val itemInfo = layoutInfo.visibleItemsInfo.find { it.index == index }
                val itemCenter = itemInfo?.let { it.offset + it.size / 2 } ?: 0

                // Calculate distance from center
                val distanceFromCenter = if (itemInfo != null) {
                    abs(viewportCenter - itemCenter).toFloat() / layoutInfo.viewportSize.height
                } else {
                    1f
                }

                val scale = (1f - (distanceFromCenter * 0.3f)).coerceIn(0.7f, 1f)
                val rotationY = (distanceFromCenter * 40f).coerceAtMost(45f)
                val alpha = (1f - (distanceFromCenter * 0.5f)).coerceIn(0.5f, 1f)

                Box(
                    modifier = Modifier
                        .graphicsLayer {
                            scaleX = scale
                            scaleY = scale
                            this.rotationY = if (itemCenter < viewportCenter) rotationY else -rotationY
                            this.alpha = alpha
                        }

                        .clip(RoundedCornerShape(Spacing.s4))
                        .background(
                            if (date == selectedDate) MaterialTheme.appColors.primary
                            else MaterialTheme.appColors.light
                        )
                        .clickable {
                            onDateSelected(date)
                        }
                        .width(Spacing.s20)
                        .height(Spacing.s25),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = date.month.name.take(3),
                            style = BodySmall().copy(
                                color = if (date == selectedDate) Color.White.copy(alpha = 0.8f)
                                else MaterialTheme.appColors.onSurface
                            )
                        )
                        Spacer(Modifier.size(Spacing.s1))
                        Text(
                            text = date.day.toString(),
                            style = H3TextStyle().copy(
                                fontWeight = FontWeight.Bold,
                                color = if (date == selectedDate) Color.White else MaterialTheme.appColors.onSurface
                            ),
                        )
                        Spacer(Modifier.size(Spacing.s1))
                        Text(
                            text = date.dayOfWeek.name.take(3),
                            style = BodySmall().copy(
                                color = if (date == selectedDate) Color.White.copy(alpha = 0.8f)
                                else MaterialTheme.appColors.onSurface
                            ),
                        )
                    }
                }
            }
        }
    }

}



//@Preview(
//    name = "Tablet",
//    widthDp = 800,
//    heightDp = 1280,
//    showBackground = true
//)
//@Composable
//fun TabletPreview() {
//    TodoPreview {
//        CarouselCalendar()
//    }
//}
