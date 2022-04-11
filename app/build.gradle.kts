import buildsrc.Depends

plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
}

android {
    compileSdkVersion(Depends.Versions.androidCompileSdkVersion)
    defaultConfig {
        applicationId = Depends.Versions.applicationId
        minSdkVersion(Depends.Versions.minSdkVersion)
        targetSdkVersion(Depends.Versions.targetSdkVersion)
        versionCode = Depends.Versions.appVersionCode
        versionName = Depends.generateVersionName()
        testInstrumentationRunner = Depends.Versions.testInstrumentationRunner
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Depends.Compose.composeVersion
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(fileTree("dir" to "libs", "include" to listOf("*.jar")))
    implementation(Depends.Libraries.kotlin)
    implementation(buildsrc.Depends.Libraries.appcompat)
    implementation(buildsrc.Depends.Libraries.android_core_ktx)
    implementation(buildsrc.Depends.Libraries.constraintlayout)
    implementation(Depends.Libraries.material)
    implementation(Depends.Libraries.fragment_ktx)

    testImplementation(buildsrc.Depends.Libraries.junit)
    androidTestImplementation(buildsrc.Depends.Libraries.test_runner)
    androidTestImplementation(buildsrc.Depends.Libraries.espresso_core)

    // compose
    implementation (Depends.Compose.compose_ui)
    implementation (Depends.Compose.compose_material)
    implementation (Depends.Compose.compose_material)
    implementation(Depends.Compose.activity_compose)
    androidTestImplementation (Depends.Compose.compose_junit)
    debugImplementation (Depends.Compose.compose_ui_tool)

    //Navigation
    implementation(Depends.Navigation.fragment)
    implementation(Depends.Navigation.uiKtx)
    implementation(Depends.Navigation.navigationCompose)

}



