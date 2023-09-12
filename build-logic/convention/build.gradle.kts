plugins {
    `kotlin-dsl`
}

group = "com.tsutsurin.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly(libs.android.tools.build.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
}

gradlePlugin {
    /**
     * Register convention plugins so they are available in the build scripts of the application
     */
    plugins {
        register("tsutsurinAndroidApplication") {
            id = "tsutsurin.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("tsutsurinAndroidLibrary") {
            id = "tsutsurin.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("tsutsurinAndroidTest") {
            id = "tsutsurin.android.test"
            implementationClass = "AndroidTestConventionPlugin"
        }
        register("tsutsurinCompose") {
            id = "tsutsurin.compose"
            implementationClass = "ComposeConventionPlugin"
        }
    }
}