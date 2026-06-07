import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.compose.multiplatform)
}

kotlin {
    android {
        namespace = "io.github.elyesmansour.floatingTabBarSample.shared"
        compileSdk = 37
        minSdk = 26

        androidResources.enable = true

        compilerOptions {
            jvmTarget = JvmTarget.JVM_11
        }
    }

    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "SampleKit"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(project(":floatingTabBar"))

            implementation(libs.compose.ui)
            implementation(libs.compose.foundation)
            implementation(libs.compose.animation)
            implementation(libs.compose.runtime)
            implementation(libs.compose.material3)
            implementation(libs.compose.ui.tooling.preview)
            implementation(libs.compose.components.resources)
            implementation(libs.androidx.lifecycle.runtime.compose)

            implementation(libs.haze)
            implementation(libs.haze.blur)
        }
    }
}

compose.resources {
    publicResClass = true
    packageOfResClass = "io.github.elyesmansour.floatingTabBarSample.shared.resources"
}
