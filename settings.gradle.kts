pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()

        maven ("https://jitpack.io")
    }
}
rootProject.name = "Damahe Code Compose UI"
include ("app")
include(":damahecode-res")
include(":damahecode-theme")
include(":core:damahecode-preferences")

include(":core:damahecode-feature")
