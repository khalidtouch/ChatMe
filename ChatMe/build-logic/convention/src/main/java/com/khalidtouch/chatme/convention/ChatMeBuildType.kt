package com.khalidtouch.chatme.convention


@Suppress("unused")
enum class ChatMeBuildType(val applicationIdSuffix: String? = null) {
    DEBUG(".debug"),
    RELEASE,
    BENCHMARK(".benchmark")
}
