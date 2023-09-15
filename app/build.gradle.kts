@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.tsutsurin.android.application)
    alias(libs.plugins.tsutsurin.compose)
    id("kotlin-kapt")
}

android {
    namespace = "com.tsutsurin.reviewsproject"

    defaultConfig {
        applicationId = "com.tsutsurin.reviewsproject"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isMinifyEnabled = false
            versionNameSuffix = ".debug"
            applicationIdSuffix = ".debug"
        }
    }
}

dependencies {

    implementation(project(":feature:authorization"))

    // Core
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    // Arch component
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.hilt.navigation.compose)
}