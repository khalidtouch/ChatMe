package com.khalidtouch.chatme.core.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class LocalDeviceDetail(
    var deviceId: String? = null,
    var deviceModel: String? = null,
    var deviceBrand: String? = null,
    var deviceCountry: String? = null,
    var osVersion: String? = null,
    var appVersion: String? = null,
    var packageName: String? = null,
    var deviceType: String? = null,
): Parcelable