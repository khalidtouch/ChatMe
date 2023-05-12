import com.khalidtouch.chatme.convention.FlavorDimension

plugins {
    id("chatme.android.application")
    id("chatme.android.application.compose")
}

android {
   // namespace = "com.khalidtouch.chatme.catalog"
    namespace = "com.khalidtouch.catalog"

    defaultConfig {
       // applicationId = "com.khalidtouch.chatme.catalog"
        applicationId = "com.khalidtouch.catalog"
        versionCode = 1
        versionName = "1.0"

    }

    buildTypes {
        val debug by getting {
            applicationIdSuffix = com.khalidtouch.chatme.convention.ChatMeBuildType.DEBUG.applicationIdSuffix
        }

        val release by getting {
            isMinifyEnabled = true
            applicationIdSuffix = com.khalidtouch.chatme.convention.ChatMeBuildType.RELEASE.applicationIdSuffix
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")


            signingConfig = signingConfigs.getByName("debug")
        }

        val benchMark by creating {
            initWith(release)
            matchingFallbacks.add("release")
            signingConfig = signingConfigs.getByName("debug")

            proguardFiles("benchmark-rules.pro")
            isMinifyEnabled = true
            applicationIdSuffix = com.khalidtouch.chatme.convention.ChatMeBuildType.BENCHMARK.applicationIdSuffix
        }
    }


    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
//    implementation(project(":core:designsystem"))
//    implementation(project(":core:ui"))

    val composeBom = platform(libs.androidx.compose.bom)
    implementation(composeBom)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.compose.runtime.livedata)
    implementation(libs.androidx.compose.runtime.tracing)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.foundation.layout)

    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.testManifest)

}