package com.khalidtouch.chatme.core.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class UserProfile(
    var uid: String? = null,
    var createdAt: Long? = null,
    var updateAt: Long? = null,
    var image: String = "",
    var username: String = "",
    var about: String = "",
    var token: String = "",
    var mobile: Mobile? = null,
    var deviceDetail: DeviceDetail? = null,
): Parcelable