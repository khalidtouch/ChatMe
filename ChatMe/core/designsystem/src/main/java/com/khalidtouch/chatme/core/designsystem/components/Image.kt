package com.khalidtouch.chatme.core.designsystem.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import coil.compose.AsyncImage
import com.khalidtouch.chatme.core.designsystem.theme.LocalTintTheme


@Composable
fun CircularAsyncImage(
    imageUrl: String,
    contentDescription: String,
    modifier: Modifier = Modifier,
    placeholder: Painter? = null,
){
    val iconTint = LocalTintTheme.current.iconTint

    AsyncImage(
        placeholder = placeholder,
        model = imageUrl,
        contentDescription = contentDescription,
        modifier = modifier.clip(CircleShape),
        colorFilter = if(iconTint != null) ColorFilter.tint(iconTint) else null
    )
}