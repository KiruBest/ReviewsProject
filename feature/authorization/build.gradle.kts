@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.tsutsurin.android.library)
    alias(libs.plugins.tsutsurin.compose)
}

android {
    namespace = "com.tsutsurin.authtorization"
}

dependencies {

    implementation(project(":core:ui"))
    implementation(project(":core:android-utils"))

    // Arch component
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
}