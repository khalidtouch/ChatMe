plugins {
    id("chatme.android.feature")
    id("chatme.android.library.compose")
}

android {
    namespace = "com.khalidtouch.chatme.chats"
}

dependencies {
    implementation(libs.androidx.activity.compose)
}