package com.imgurujeet.todolist.todoApp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MovableContent
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.imgurujeet.todolist.todoApp.ui.components.CustomButton
import com.imgurujeet.todolist.todoApp.ui.theme.AppColors
import com.imgurujeet.todolist.todoApp.ui.theme.TodoAppTheme
import com.imgurujeet.todolist.todoApp.ui.theme.TodoPreview
import com.imgurujeet.todolist.todoApp.ui.theme.appColors
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.dsl.module
import todolist.composeapp.generated.resources.Res
import todolist.composeapp.generated.resources.blue_desk_cal
import todolist.composeapp.generated.resources.blue_stopwatch
import todolist.composeapp.generated.resources.coffee_cup
import todolist.composeapp.generated.resources.female_sitting
import todolist.composeapp.generated.resources.flower_pot
import todolist.composeapp.generated.resources.pie_chart
import todolist.composeapp.generated.resources.smartphone_notification

@Composable
fun OnBoardingScreen(){

    TodoBackgroundScreen(
        shouldShowDotsAndIcons = true
    ){
        BoxWithConstraints(
            modifier = Modifier.fillMaxSize()
        ) {
            val screenWidth = this@BoxWithConstraints.maxWidth
            val screenHeight = this@BoxWithConstraints.maxHeight

            val isWideScreen = screenWidth > screenHeight

            val horizontalPadding = if (isWideScreen) {
                screenWidth * 0.2f   // more padding on desktop
            } else {
                screenWidth * 0.08f   // mobile
            }

            val imageWidthFraction = if (isWideScreen) {
                0.4f   // prevent huge image on laptop
            } else {
                0.85f
            }

            val topSpacer = if (isWideScreen) {
                screenHeight * 0.05f
            } else {
                screenHeight * 0.1f
            }

            val bottomPadding = if (isWideScreen) {
                screenHeight * 0.1f
            } else {
                screenHeight * 0.1f
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = horizontalPadding),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                Spacer(modifier = Modifier.height(topSpacer))

                Box(
                    modifier = Modifier
                        .weight(0.85f)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(Res.drawable.female_sitting),
                        contentDescription = "onboarding_screen_illustration",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .fillMaxWidth(imageWidthFraction)
                            .aspectRatio(1f)
                    )
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(bottom = bottomPadding)
                ) {
                    Text(
                        "Task Management &\nTo-Do List",
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground,
                        textAlign = TextAlign.Center,
                        lineHeight = 28.sp
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "This productive tool is designed to help\nyou better manage your task\nproject-wisely conveniently!",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Normal,
                        color = MaterialTheme.colorScheme.onBackground,
                        textAlign = TextAlign.Center,
                        lineHeight = 22.sp
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    CustomButton(
                        onClick = {},
                        text = "Let's Start",
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }

    }

}


@Composable
fun TodoBackgroundScreen(
    modifier: Modifier = Modifier,
    shouldShowDotsAndIcons: Boolean = false,
    content: @Composable () -> Unit ={},
){
    val colors = MaterialTheme.appColors

    BoxWithConstraints(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.radialGradient(
                    listOf(
                        colors.cream,
                        colors.softCyan,
                        colors.lightBlue
                    ),
                    center = Offset(x=0.5f, y = 0.5f),
                    radius = 1500f
                )
            )



    ) {
        FloatingElements(shouldShowDotsAndIcons = shouldShowDotsAndIcons)
        content()
    }
}


@Composable
fun BoxWithConstraintsScope.FloatingElements(
    shouldShowDotsAndIcons: Boolean = true
){

    if (shouldShowDotsAndIcons){
        Image(
            painter = painterResource(Res.drawable.blue_stopwatch),
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .offset(
                    x = maxWidth * 0.20f,
                    y = maxHeight * 0.15f
                )
        )


        Image(
            painter = painterResource(Res.drawable.pie_chart),
            contentDescription = null,
            modifier = Modifier
                .size(32.dp)
                .offset(
                    x = maxWidth * 0.15f,
                    y = maxHeight * 0.30f
                )
        )

        Image(
            painter = painterResource(Res.drawable.flower_pot),
            contentDescription = null,
            modifier = Modifier
                .size(52.dp)
                .offset(
                    x = maxWidth * 0.12f,
                    y = maxHeight * 0.48f
                )
        )

        Image(
            painter = painterResource(Res.drawable.coffee_cup),
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
                .offset(
                    x = maxWidth * 0.14f,
                    y = maxHeight * 0.53f
                )
        )

        Image(
            painter = painterResource(Res.drawable.blue_desk_cal),
            contentDescription = null,
            modifier = Modifier
                .size(52.dp)
                .offset(
                    x = maxWidth * 0.72f,
                    y = maxHeight * 0.22f
                )
        )

        Image(
            painter = painterResource(Res.drawable.smartphone_notification),
            contentDescription = null,
            modifier = Modifier
                .size(72.dp)
                .offset(
                    x = maxWidth * 0.70f,
                    y = maxHeight * 0.45f
                )
        )


        ColorDots(
            Color(0xFF00A5BA),
            x = maxWidth * 0.72f,
            y = maxHeight * 0.15f,
            size = 12.dp
        )

        ColorDots(
            Color(0xFF008E9E),
            x = maxWidth * 0.72f,
            y = maxHeight * 0.45f,
            size = 6.dp
        )

        ColorDots(
            Color(0xFF746500),
            x = maxWidth * 0.60f,
            y = maxHeight * 0.54f,
            size = 10.dp
        )

        ColorDots(
            Color(0xFF7448EE),
            x = maxWidth * 0.50f,
            y = maxHeight * 0.15f,
            size = 6.dp
        )

        ColorDots(
            Color(0xFF86004B),
            x = maxWidth * 0.30f,
            y = maxHeight * 0.56f,
            size = 7.dp
        )

        ColorDots(
            Color(0xFF01CAE5),
            x = maxWidth * 0.40f,
            y = maxHeight * 0.60f,
            size = 4.dp
        )

    }
    BlurredCircles(Color(0x1600A0EA), 50.dp, maxHeight.value.dp/2, 100.dp)
    BlurredCircles(Color(0x1E9E008E), maxWidth.value.div(1.5).dp, maxHeight.value.div(1.4f).dp, 80.dp)
    BlurredCircles(Color(0x52746500), (-28).dp, maxHeight.value.div(5).dp, 60.dp)
    BlurredCircles(Color(0x2502BF04), maxWidth.value.dp-160.dp, 0.dp, 100.dp)

}

@Composable
fun ColorDots(colors: Color, x : Dp, y : Dp, size : Dp){
    Box(
        modifier = Modifier
            .size(size)
            .offset(x=x,y=y)
            .background(colors, CircleShape)
    )

}

@Composable
fun BlurredCircles(
    color: Color, x: Dp, y: Dp, size: Dp,
){

    Box(
        modifier = Modifier
            .size(size)
            .offset(x=x,y=y)
            .blur(
                radius = 50.dp,
                edgeTreatment = BlurredEdgeTreatment.Unbounded
            )
            .background(color,CircleShape)
    )

}



@Preview(name = "Light", showBackground = true)
@Composable
fun TodoBackgroundLightPreview() {
    TodoPreview {
        OnBoardingScreen()
    }
}

@Preview(name = "Dark", showBackground = true)
@Composable
fun TodoBackgroundDarkPreview() {
    TodoPreview(darkTheme = true) {
        OnBoardingScreen()
    }
}

@Preview(
    name = "Tablet",
    widthDp = 800,
    heightDp = 1280,
    showBackground = true
)
@Composable
fun TabletPreview() {
    TodoPreview {
        OnBoardingScreen()
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
        OnBoardingScreen()
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
        OnBoardingScreen()
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
        OnBoardingScreen()
    }
}

