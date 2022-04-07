package buildsrc

object Depends {

    object Versions {
        const val kotlinVersion = "1.6.10"
        const val applicationId = "com.banana.realrent"
        const val appVersionCode = 1_000_000
        const val gradleVersion = "7.2.0-alpha07"
        const val androidCompileSdkVersion = 31
        const val targetSdkVersion = 31
        const val minSdkVersion = 21
        const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        const val composeVersion = "1.1.1"
        const val activityComposeVersion = "1.4.0"
        const val supportVersion = "1.4.1"
        const val coreKtxVersion = "1.7.0"
        const val constraintLayoutVersion = "2.1.3"
        const val junitVersion = "4.13.2"
        const val supportTestVersion = "1.4.0"
        const val espressoVersion = "3.4.0"
        const val materialVersion = "1.4.0"
    }


    object ClassPaths {
        const val gradle = "com.android.tools.build:gradle:${Versions.gradleVersion}"
        const val kotlin_gradle_plugin = "gradle-plugin"
    }

    object Libraries {
        const val kotlin =
            "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlinVersion}"
        const val appcompat = "androidx.appcompat:appcompat:${Versions.supportVersion}"
        const val android_core_ktx =
            "androidx.core:core-ktx:${Versions.coreKtxVersion}"
        const val constraintlayout =
            "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"
        const val junit = "junit:junit:${Versions.junitVersion}"
        const val test_runner = "androidx.test:runner:${Versions.supportTestVersion}"
        const val espresso_core = "androidx.test.espresso:espresso-core:${Versions.espressoVersion}"
        const val material = "com.google.android.material:material:${Versions.materialVersion}"

        // compose
        const val compose_ui = "androidx.compose.ui:ui:${Versions.composeVersion}"
        const val compose_material = "androidx.compose.material:material:${Versions.composeVersion}"
        const val compose_preview = "androidx.compose.ui:ui-tooling-preview:${Versions.composeVersion}"
        const val compose_junit = "androidx.compose.ui:ui-test-junit4:${Versions.composeVersion}"
        const val compose_ui_tool = "androidx.compose.ui:ui-tooling:${Versions.composeVersion}"
        const val activity_compose = "androidx.activity:activity-compose:${Versions.activityComposeVersion}"

    }

    fun generateVersionName(): String {
        val patch: Int = Versions.appVersionCode.rem(1000)
        val minor: Int = (Versions.appVersionCode / 1000).rem(1000)
        val major: Int = (Versions.appVersionCode / 1000000).rem(1000)

        return "$major.$minor.$patch"
    }
}