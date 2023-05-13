package com.khalidtouch.chatme.core.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class LocalChatUser(
    val userId: String,
    val username: String,
    val profile: UserProfile,
    val documentId: String,
    val availableOnLocal: Boolean,
    val unread: Int,
    val searched: Boolean,
    val selected: Boolean,
): Parcelable