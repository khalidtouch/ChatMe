package com.khalidtouch.chatme.core.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable


@Parcelize
@Serializable
data class LocalGroupWithMessages(
    val group: LocalGroup,
    val messages: List<LocalGroupMessage>,
): Parcelable