package com.khalidtouch.chatme.core.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.khalidtouch.chatme.core.data.model.LocalChatUser
import com.khalidtouch.chatme.core.designsystem.icons.CMIcons


@Composable
fun SelectContactItem(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    image: @Composable () -> Unit,
    text: @Composable () -> Unit,
) {
    SelectContactItemContent(
        image = image,
        text = text,
        modifier = modifier,
        onClick = onClick
    )
}


@Composable
fun SelectContactExtra(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    icon: @Composable () -> Unit,
    text: @Composable () -> Unit,
) {
    SelectContactItemContent(
        image = {
            Box(
                modifier = modifier
                    .background(
                        color = MaterialTheme.colorScheme.primary,
                        shape = CircleShape,
                    )
                    .clip(CircleShape)
                    .size(SelectContactExtraDefaults.iconSize),
                contentAlignment = Alignment.Center
            ) {
                CompositionLocalProvider(
                    LocalContentColor provides MaterialTheme.colorScheme.onPrimary
                ) {
                    icon()
                }
            }
        },
        text = text,
        modifier = modifier,
        onClick = onClick
    )
}


@Composable
private fun SelectContactItemContent(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    image: @Composable () -> Unit,
    text: @Composable () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(
                enabled = true,
                onClick = onClick,
                role = Role.Button,
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = modifier.size(SelectContactExtraDefaults.iconContainerSize),
            contentAlignment = Alignment.Center
        ) {
            image()
        }
        Box(
            modifier = modifier
                .weight(1f)
                .padding(horizontal = 8.dp)
        ) {
            text()
        }
    }
}

object SelectContactExtraDefaults {
    val iconContainerSize = 54.dp
    val iconSize = 42.dp
}

@Composable
@Preview
private fun SelectContactExtraPreview() {
    SelectContactExtra(
        icon = {
            Icon(
                painter = painterResource(id = CMIcons.Group),
                contentDescription = null
            )
        },
        text = {
            ProvideTextStyle(MaterialTheme.typography.titleMedium) {
                Text(
                    text = "New Group"
                )
            }
        }
    )
}