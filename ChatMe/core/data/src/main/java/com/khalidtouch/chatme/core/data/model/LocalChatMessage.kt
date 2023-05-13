package com.khalidtouch.chatme.core.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class LocalChatMessage(
    val chatUserId: String,
    var chatUsers: ArrayList<String>? = null,
    val messageType: MessageType,
    val deliveryState: MessageDeliveryState,
    val textMessage: TextMessage? = null,
    val imageMessage: ImageMessage? = null,
    val audioMessage: AudioMessage? = null,
    val videoMessage: VideoMessage? = null,
    val fileMessage: FileMessage? = null,
    val senderImage: String,
    val senderName: String,
    val sender: String,
    val recipient: String,
    val seenTime: Long,
    val deliveryTime: Long,
    val createdAt: Long,
) : Parcelable


@Serializable
@Parcelize
data class TextMessage(
    val text: String,
) : Parcelable


@Serializable
@Parcelize
data class AudioMessage(
    val uri: String,
    val duration: Int,
) : Parcelable


@Serializable
@Parcelize
data class ImageMessage(
    val uri: String,
    val imageType: String,
) : Parcelable


@Serializable
@Parcelize
data class VideoMessage(
    val uri: String,
    val duration: Int,
) : Parcelable


@Serializable
@Parcelize
data class FileMessage(
    val filename: String,
    val uri: String,
    val duration: Int,
) : Parcelable


enum class MessageType {
    Text, Image, Audio, Video, File,
}

enum class MessageDeliveryState {
    Sending, Sent, Delivered, Seen, Failed,
}