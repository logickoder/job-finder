@file:Suppress("UnstableApiUsage","DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "dev.logickoder.jobfinder"
    compileSdk = 34

    defaultConfig {
        applicationId = "dev.logickoder.jobfinder"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        // Flag to enable support for the new language APIs
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = rootProject.libs.versions.compose.compiler.get()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // for using some java 8 classes like LocalDate with older versions of android
    coreLibraryDesugaring(libs.core.java8)

    // Appyx
    implementation(libs.appyx)

    implementation(libs.core)
    implementation(libs.core.appcompat)

    // Material Design
    implementation(libs.core.material)
    implementation(libs.compose.material)
    implementation(libs.compose.material.icons)

    // Compose
    implementation(platform(libs.compose))
    implementation(libs.compose.activity)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.fonts)
    implementation(libs.compose.ui.tooling.preview)
    debugImplementation(libs.compose.ui.tooling)
    androidTestImplementation(platform(libs.compose))
    androidTestImplementation(libs.compose.ui.test.junit)
    androidTestImplementation(libs.compose.ui.test.manifest)

    // lifecycle
    implementation(libs.lifecycle.runtime)
    implementation(libs.lifecycle.viewmodel)
    implementation(libs.lifecycle.viewmodel.compose)

    // preferences datastore
    implementation(libs.datastore)

    // Kotlinx
    implementation(libs.kotlin.immutable)
    implementation(libs.kotlin.serialization)

    // Napier
    implementation(libs.napier)

    testImplementation(libs.junit4)
    androidTestImplementation(libs.expresso)
    androidTestImplementation(libs.junit4.androidx)
}