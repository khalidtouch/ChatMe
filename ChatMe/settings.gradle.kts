pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "ChatMe"
include (":app")
include (":core")
include (":feature")
include (":core:model")
include (":core:notification")
include (":core:ui")
include (":core:datastore")
include (":core:database")
include (":core:network")
include (":core:designsystem")
include (":core:data")
include (":core:common")
include (":core:domain")