package com.khalidtouch.chatme.core.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class LocalGroup(
    val groupId: String,
    val description: String,
    val createdAt: Long,
    val createdBy: String,
    val groupImage: String,
    val members: ArrayList<LocalChatUser>,
    val memberProfiles: ArrayList<UserProfile>,
    val unread: Int,
) : Parcelable