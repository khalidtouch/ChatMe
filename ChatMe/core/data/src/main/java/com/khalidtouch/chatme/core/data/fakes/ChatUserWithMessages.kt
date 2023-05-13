package com.khalidtouch.chatme.core.data.fakes

import com.khalidtouch.chatme.core.data.model.LocalChatUser
import com.khalidtouch.chatme.core.data.model.LocalChatUserWithMessages
import com.khalidtouch.chatme.core.data.model.DeviceDetail
import com.khalidtouch.chatme.core.data.model.LocalChatMessage
import com.khalidtouch.chatme.core.data.model.MessageDeliveryState
import com.khalidtouch.chatme.core.data.model.MessageType
import com.khalidtouch.chatme.core.data.model.UserProfile
import com.khalidtouch.chatme.core.data.model.Mobile
import com.khalidtouch.chatme.core.data.model.TextMessage
import java.util.UUID


private val messages = listOf(
    LocalChatMessage(
        chatUserId = UUID.randomUUID().toString(),
        chatUsers = null,
        messageType = MessageType.Text,
        deliveryState = MessageDeliveryState.Sending,
        textMessage = TextMessage("Hey, how are you, this morning?"),
        sender = "Bright Omo",
        senderImage = "",
        senderName = "Bright Omo",
        recipient = "Mikel Oraimo",
        seenTime = 385738945893L,
        deliveryTime = 2423232L,
        createdAt = 232093055L,
    )
)

val FakeChatUserWithMessages = listOf(
    LocalChatUserWithMessages(
        user = LocalChatUser(
            userId = UUID.randomUUID().toString(),
            username = "Mikel Oraimo",
            profile = UserProfile(
                uid = UUID.randomUUID().toString(),
                createdAt = 1434353L,
                updateAt = 649634292L,
                image = "",
                username = "Mikel Oraimo",
                about = "Mikel Oraimo is a student of MIT",
                token = "fjegjbjfbjdsds",
                mobile = Mobile(
                    country = "NGN",
                    phone = "08030607335"
                ),
                deviceDetail = DeviceDetail(
                    deviceId = "TECNO-SPARK4-538u593fn8i3",
                    deviceModel = "TECNO-SPARK4",
                    deviceBrand = "TECNO",
                    deviceCountry = "NGN",
                    osVersion = "Android 10",
                    appVersion = "v1.0.2",
                    packageName = "com.khalidtouch.chatme",
                    deviceType = "Mobile"
                )
            ),
            documentId = UUID.randomUUID().toString(),
            availableOnLocal = true,
            unread = 1,
            searched = false,
            selected = false,
        ),
        messages = messages
    )
)
