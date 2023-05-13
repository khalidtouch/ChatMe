package com.khalidtouch.chatme.core.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.khalidtouch.chatme.core.data.fakes.FakeChatUserWithMessages
import com.khalidtouch.chatme.core.data.model.LocalChatUserWithMessages
import com.khalidtouch.chatme.core.data.model.MessageType
import com.khalidtouch.chatme.core.designsystem.components.CMChatBadge
import com.khalidtouch.chatme.core.designsystem.components.CircularAsyncImage
import com.khalidtouch.chatme.core.designsystem.icons.CMIcons

@Composable
internal fun ChatItem(
    modifier: Modifier = Modifier,
    chatUserWithMessages: LocalChatUserWithMessages,
    onClickImage: () -> Unit = {},
    onClickChat: () -> Unit = {},
    onLongPress: () -> Unit = {},
) {
    ChatItemWrapper(
        chatUserWithMessages = chatUserWithMessages,
        modifier = modifier,
        onLongPress = onLongPress,
        onClickChat = onClickChat,
        onClickImage = onClickImage,
    )
}


@Composable
private fun ChatItemWrapper(
    modifier: Modifier = Modifier,
    onClickImage: () -> Unit = {},
    onClickChat: () -> Unit = {},
    onLongPress: () -> Unit = {},
    chatUserWithMessages: LocalChatUserWithMessages,
) {
    BoxWithConstraints(modifier = modifier.pointerInput(Unit) {
        detectTapGestures(
            onLongPress = { onLongPress() }
        )
    }) {
        val maxWidth = maxWidth

        Row(
            modifier = modifier
                .fillMaxWidth()
                .clickable(
                    enabled = true,
                    onClick = onClickChat,
                    role = Role.Button
                ),
            verticalAlignment = Alignment.CenterVertically,
        ) {

            val chatUsernameStyle = MaterialTheme.typography.titleLarge
            val lastMessageStyle = MaterialTheme.typography.labelMedium
            val timestampTextStyle = MaterialTheme.typography.labelMedium.copy(
                color = if (chatUserWithMessages.user.unread > 0) {
                    MaterialTheme.colorScheme.secondary
                } else MaterialTheme.colorScheme.inverseSurface
            )

            val message: String =
                when (val lastMessage = chatUserWithMessages.messages.lastOrNull()) {
                    null -> ""
                    else -> {
                        lastMessage.textMessage?.text.orEmpty()
                    }
                }


            ChatItemImage(
                imageUrl = chatUserWithMessages.user.profile.image,
                contentDescription = chatUserWithMessages.user.username,
                modifier = modifier.clickable(
                    enabled = true,
                    onClick = onClickImage,
                    role = Role.Button,
                )
            )

            ChatItemContent(
                chatUserName = {
                    ProvideTextStyle(chatUsernameStyle) {
                        Text(
                            text = chatUserWithMessages.user.username,
                            modifier = modifier.width(maxWidth.times(0.75f))
                        )
                    }
                },
                lastMessage = {
                    ProvideTextStyle(lastMessageStyle) {
                        Text(
                            text = message,
                            modifier = modifier.width(maxWidth.times(0.75f)),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )
                    }
                },
                timestamp = {
                    ProvideTextStyle(timestampTextStyle) {
                        Text(
                            text = chatUserWithMessages.messages.lastOrNull()?.deliveryTime.toString()
                        )
                    }
                },
                unreadMessageBadge = {
                    CMChatBadge(
                        labelColor = MaterialTheme.colorScheme.onSecondary,
                        surfaceColor = MaterialTheme.colorScheme.secondary,
                        label = {
                            Text(
                                text = chatUserWithMessages.messages.size.toString(),
                                style = MaterialTheme.typography.labelMedium
                            )
                        }
                    )
                }
            )
        }
    }
}


@Composable
private fun ChatItemContent(
    modifier: Modifier = Modifier,
    chatUserName: @Composable () -> Unit,
    lastMessage: @Composable () -> Unit,
    timestamp: @Composable () -> Unit,
    unreadMessageBadge: @Composable (() -> Unit)? = null,
) {
    Column(
        modifier = modifier,
    ) {
        Row(modifier = modifier.fillMaxWidth().padding(end = 8.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = modifier.weight(1f)) {
                chatUserName()
            }
            timestamp()
        }
        Row(modifier = modifier.fillMaxWidth().padding(end = 8.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = modifier.weight(1f)) {
                lastMessage()
            }
            if (unreadMessageBadge != null) {
                unreadMessageBadge()
            }
        }
    }
}

@Composable
private fun ChatItemImage(
    modifier: Modifier = Modifier,
    imageUrl: String,
    contentDescription: String,
    imageSize: Dp = ChatDefaults.ImageSize,
    @DrawableRes placeholder: Int = CMIcons.Placeholder
) {
    Box(
        modifier = modifier.size(imageSize),
        contentAlignment = Alignment.Center
    ) {
        CircularAsyncImage(
            imageUrl = imageUrl,
            contentDescription = contentDescription,
            placeholder = painterResource(id = placeholder),
        )
    }
}


object ChatDefaults {
    val ImageSize = 72.dp
}


@Composable
@Preview
private fun ChatItemImagePreview() {
    ChatItemImage(
        imageUrl = "",
        contentDescription = "",
    )
}

@Composable
@Preview
private fun ChatItemPreview() {
    ChatItem(
        chatUserWithMessages = FakeChatUserWithMessages[0],
    )
}