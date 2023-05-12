package com.khalidtouch.chatme.core.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class LocalPushMessage(
    var messageType: String? = null,
    var destination: String? = null,
    var title: String? = null,
    var message: String? = null,
    var body: String? = null,
) : Parcelable