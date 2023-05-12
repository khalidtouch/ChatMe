package com.khalidtouch.chatme.core.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class LocalMobile(
    var country: String = "",
    var phone: String = "",
) : Parcelable