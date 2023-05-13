package com.khalidtouch.chatme.core.designsystem.icons

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector
import com.khalidtouch.chatme.core.designsystem.R as CMResource

object CMIcons {
    val AddCall = CMResource.drawable.icon_add_call
    val AddContact = CMResource.drawable.icon_add_contact
    val Account = CMResource.drawable.icon_account
    val Back = CMResource.drawable.icon_back
    val Camera = CMResource.drawable.icon_camera
    val Camera2 = CMResource.drawable.icon_camera2
    val Chats = CMResource.drawable.icon_chats
    val Group = CMResource.drawable.icon_group
    val Help = CMResource.drawable.icon_help
    val Invite = CMResource.drawable.icon_invite
    val Language = CMResource.drawable.icon_language
    val More = CMResource.drawable.icon_more
    val Notification = CMResource.drawable.icon_notification
    val Placeholder = CMResource.drawable.icon_profile_placeholder
    val Privacy = CMResource.drawable.icon_privacy
    val Search = CMResource.drawable.icon_search
    val Storage = CMResource.drawable.icon_storage
}

sealed class Icon {
    data class ImageVectorIcon(val imageVector: ImageVector) : Icon()
    data class DrawableResourceIcon(@DrawableRes val id: Int) : Icon()
}
