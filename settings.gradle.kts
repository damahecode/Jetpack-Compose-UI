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
rootProject.name = "Jetpack-Compose-UI"
include ("app")
include(":core:resource")
include(":material-theme")
include(":core:system")
include(":core:ui")

include(":compose:featured")
include(":compose:demo-ui")
include(":compose:template:responsive-screen")