package com.imgurujeet.todolist.todoApp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.github.alexzhirkevich.compottie.ExperimentalCompottieApi
import io.github.alexzhirkevich.compottie.LottieCompositionSpec
import io.github.alexzhirkevich.compottie.animateLottieCompositionAsState
import io.github.alexzhirkevich.compottie.dynamic.rememberLottieDynamicProperties
import io.github.alexzhirkevich.compottie.rememberLottieAnimatable
import io.github.alexzhirkevich.compottie.rememberLottieComposition
import io.github.alexzhirkevich.compottie.rememberLottiePainter
import todolist.composeapp.generated.resources.Res


@OptIn(ExperimentalCompottieApi::class)
@Composable
fun AnimatedNavIcon(
    lottieFile: String,
    isSelected: Boolean,
    size: Dp = 26.dp,
    staticColor: Color,
    animatedColor: Color
) {
    val composition by rememberLottieComposition {
        LottieCompositionSpec.JsonString(
            Res.readBytes(lottieFile).decodeToString()
        )
    }

    val animatable = rememberLottieAnimatable()

    LaunchedEffect(isSelected, composition) {
        if (composition == null) return@LaunchedEffect

        if (isSelected) {
            animatable.animate(
                composition = composition,
                iterations = 1
            )
        } else {
            animatable.snapTo(progress = 0f)
        }
    }

    //  STATIC color (unselected)
    val staticProperties = rememberLottieDynamicProperties {
        shapeLayer("**") {
            fill("**") { color { staticColor } }
            stroke("**") { color { staticColor } }
        }
    }

    //  ANIMATED color (selected)
    val animatedProperties = rememberLottieDynamicProperties {
        shapeLayer("**") {
            fill("**") { color { animatedColor } }
            stroke("**") { color { animatedColor } }
        }
    }

    Image(
        painter = rememberLottiePainter(
            composition = composition,
            progress = { animatable.progress },
            dynamicProperties = if (isSelected) animatedProperties else staticProperties
        ),
        contentDescription = null,
        modifier = Modifier.size(size)
    )
}

