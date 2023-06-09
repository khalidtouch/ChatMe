package com.khalidtouch.chatme.core.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CMTabRow(
    selectedTabIndex: Int,
    modifier: Modifier = Modifier,
    tabs: @Composable () -> Unit,
) {
    TabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                height = 4.dp,
                color = MaterialTheme.colorScheme.onPrimary
            )
        },
        tabs = tabs,
    )
}


@Composable
fun CMTab(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    tabState: TabState,
    unreadChats: Int = 0,
    text: @Composable () -> Unit,
) {
    Tab(
        selected = selected,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        selectedContentColor = MaterialTheme.colorScheme.onPrimary,
        unselectedContentColor = Color.Transparent,
        text = {
            val color = if (selected) MaterialTheme.colorScheme.onPrimary else
                MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.7f)
            Box(
                modifier = Modifier.padding(
                    top = CMTabDefaults.TabTopPadding
                )
            ) {
                CMTabText(
                    tabState = tabState,
                    unreadChats = unreadChats,
                    color = color,
                    text = text,
                )
            }
        }
    )
}


@Composable
fun CMTabText(
    modifier: Modifier = Modifier,
    tabState: TabState,
    color: Color = Color.Unspecified,
    text: @Composable () -> Unit,
    unreadChats: Int = 0,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Top
    ) {
        CompositionLocalProvider(
            LocalContentColor provides color,
        ) {
            text()
        }

        if (tabState.state is ReadState.Unread) {
            if (tabState.type == TabType.CHATS && unreadChats > 0) {
                Box(
                    modifier = modifier.padding(
                        bottom = CMTabDefaults.LabelBottomPadding,
                        start = 4.dp
                    ),
                    contentAlignment = Alignment.TopCenter
                ) {
                    // chat badge
                    CMChatBadge(
                        labelColor = MaterialTheme.colorScheme.primary,
                        surfaceColor = MaterialTheme.colorScheme.onPrimary
                    ) {
                        Text(
                            text = unreadChats.toString(),
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                }
            }

            if (tabState.type == TabType.EXTRAS) {
                //dot badge
                Box(
                    modifier = modifier.padding(4.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Badge(
                        color = color,
                    )
                }
            }
        }
    }
}


data class TabState(
    val type: TabType,
    val state: ReadState,
)


enum class TabType {
    CHATS, EXTRAS
}

sealed class ReadState {
    object Read : ReadState()
    object Unread : ReadState()
}


object CMTabDefaults {
    val TabTopPadding = 7.dp
    val LabelBottomPadding = 4.dp
}


@Composable
@Preview
private fun CMTabPreview() {
    CMTab(
        onClick = {},
        selected = true,
        unreadChats = 230,
        tabState = TabState(
            type = TabType.CHATS,
            state = ReadState.Unread
        ),
        text = { Text(text = "Chats") }
    )
}