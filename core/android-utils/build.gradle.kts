@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.tsutsurin.android.library)
    alias(libs.plugins.tsutsurin.compose)
}

android {
    namespace = "com.tsutsurin.android_utils"
}

dependencies {
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
}