package com.khalidtouch.chatme.core.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable


@Serializable
@Parcelize
data class LocalGroupMessage(
    val sender: String,
    val senderName: String,
    val senderImage: String,
    val recipients: ArrayList<String>,
    val groupId: String,
    val createdAt: Long,
    val deliveryTimes: ArrayList<Long>,
    val seenTimes: ArrayList<Long>,
    val messageType: MessageType,
    val textMessage: TextMessage? = null,
    val imageMessage: ImageMessage? = null,
    val audioMessage: AudioMessage? = null,
    val videoMessage: VideoMessage? = null,
    val fileMessage: FileMessage? = null,
) : Parcelable