package com.khalidtouch.chatme.core.designsystem.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter.State.Empty.painter
import com.khalidtouch.chatme.core.designsystem.icons.CMIcons


@Composable
fun CMFabButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    enabled: Boolean = true,
    colors: IconButtonColors = IconButtonDefaults.iconButtonColors(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
        disabledContainerColor = MaterialTheme.colorScheme.inverseSurface,
        disabledContentColor = MaterialTheme.colorScheme.inverseOnSurface,
    ),
    icon: @Composable () -> Unit,
) {
    IconButton(
        onClick = onClick,
        enabled = enabled,
        colors = colors,
        content = icon,
        modifier = modifier
            .size(CMFabButtonDefaults.buttonSize)
            .clip(CircleShape)
    )
}


object CMFabButtonDefaults {
    val buttonSize = 58.dp
}


@Composable
@Preview
private fun CMFabButtonPreview() {
    CMFabButton(
        icon = {
            Icon(
                painter = painterResource(id = CMIcons.Camera),
                contentDescription = null
            )
        }
    )
}