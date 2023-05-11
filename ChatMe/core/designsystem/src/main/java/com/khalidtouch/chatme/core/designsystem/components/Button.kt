package com.khalidtouch.chatme.core.designsystem.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun CMButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    enabled: Boolean = true,
    expanded: Boolean = false,
    text: @Composable () -> Unit,
    icon: @Composable () -> Unit,
) {
    CMButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        content = {
            CMButtonContent(
                text = text,
                icon = icon,
                expanded = expanded
            )
        }
    )
}


@Composable
fun CMButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    enabled: Boolean = true,
    content: @Composable RowScope.() -> Unit,
) {
    TextButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        content = content,
    )
}

@Composable
fun CMButtonContent(
    text: @Composable () -> Unit,
    icon: @Composable () -> Unit,
    expanded: Boolean = false,
) {
    Box(Modifier.sizeIn(maxHeight = ButtonDefaults.IconSize)) {
        icon()
    }

    if (expanded) {
        Box(
            Modifier
                .padding(
                    start = ButtonDefaults.IconSpacing
                )
        ) {
            text()
        }
    }
}

object CMButtonDefaults {
    const val DisabledOutlinedButtonBorderAlpha = 0.12f
    val OutlinedButtonBorderWidth = 1.dp
}