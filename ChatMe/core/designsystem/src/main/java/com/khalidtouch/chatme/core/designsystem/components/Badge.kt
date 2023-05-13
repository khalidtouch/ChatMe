package com.khalidtouch.chatme.core.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun CMChatBadge(
    modifier: Modifier = Modifier,
    labelColor: Color,
    surfaceColor: Color,
    label: @Composable () -> Unit,
) {
    Surface(
        modifier = modifier,
        shape = CircleShape,
        color = surfaceColor,
    ) {
        CompositionLocalProvider(
            LocalContentColor provides labelColor
        ) {
            Box(
                modifier = modifier
                    .padding(2.dp)
                    .sizeIn(
                        minWidth = CMBadgeDefaults.containerSize,
                        minHeight = CMBadgeDefaults.containerSize
                    ), contentAlignment= Alignment.Center,
            ) {
                label()
            }
        }
    }
}


@Composable
fun Badge(
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
) {
    Box(
        modifier = modifier
            .background(
                shape = CircleShape,
                color = if (color == Color.Unspecified) {
                    MaterialTheme.colorScheme.onSecondaryContainer
                } else color
            )
            .size(CMBadgeDefaults.size)
            .clip(CircleShape)
    )
}


object CMBadgeDefaults {
    val size = 5.dp
    val containerSize = 18.dp
}


@Composable
@Preview
private fun BadgePreview() {
    Badge()
}

@Composable
@Preview
private fun CMChatBadgePreview() {
    CMChatBadge(
        labelColor = Color.White,
        surfaceColor = Color.Blue,
        label = {
            Text(
                text = "1024"
            )
        }
    )
}