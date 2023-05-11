plugins {
    id("chatme.android.library")
    id("chatme.android.hilt")
}

android {
    namespace = "com.khalidtouch.chatme.core.network"
}

dependencies {
    implementation(libs.kotlinx.coroutines.android)
}