plugins {
    id("chatme.android.feature")
    id("chatme.android.library.compose")
}

android {
    namespace = "com.khalidtouch.chatme.contacts"
}

dependencies {
    implementation(libs.androidx.activity.compose)
    implementation(libs.accompanist.navigation.animation)
}