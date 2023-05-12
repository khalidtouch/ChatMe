package com.khalidtouch.chatme.core.data.model

data class LocalUserStatus(
    val userId: String? = null,
    val availability: Availability = Availability.Offline,
    val typingStatus: TypingStatus = TypingStatus.Idle,
    val lastSeen: Long = 0L,
)


enum class Availability {
    Offline, Online
}

enum class TypingStatus {
    Typing, Idle
}