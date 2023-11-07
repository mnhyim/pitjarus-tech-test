pluginManagement {
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

rootProject.name = "Pitjarus Tech Test"
include(":app")
include(":common:ui")
include(":domain")
include(":data")
include(":feature:auth")
include(":feature:main")
