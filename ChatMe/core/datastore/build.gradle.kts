plugins {
    id("chatme.android.library")
    id("chatme.android.hilt")
}

android {
    namespace = "com.khalidtouch.chatme.core.datastore"
}

dependencies {
    implementation(libs.kotlinx.coroutines.android)
}