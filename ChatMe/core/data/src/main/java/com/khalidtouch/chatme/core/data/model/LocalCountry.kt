package com.khalidtouch.chatme.core.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class LocalCountry(
    val code: String,
    val countryName: String,
    val money: String,
    val noCode: String,
) : Parcelable