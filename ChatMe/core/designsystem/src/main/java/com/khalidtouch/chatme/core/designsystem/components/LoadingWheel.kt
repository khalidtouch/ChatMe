package com.khalidtouch.chatme.core.designsystem.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CMLoadingWheel(
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
) {
    CircularProgressIndicator(
        color = if (color == Color.Unspecified) {
            MaterialTheme.colorScheme.surface
        } else color,
        modifier = modifier
            .size(CMLoadingWheelDefaults.size)
    )
}



object CMLoadingWheelDefaults {
    val size = 8.dp
}

@Composable
@Preview
private fun CMLoadingWheelPreview() {
    CMLoadingWheel()
}