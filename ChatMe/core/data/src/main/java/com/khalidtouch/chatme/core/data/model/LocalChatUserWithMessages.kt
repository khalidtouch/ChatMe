package com.khalidtouch.chatme.core.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class LocalChatUserWithMessages(
    val user: LocalChatUser,
    val messages: List<LocalChatMessage>
) : Parcelable