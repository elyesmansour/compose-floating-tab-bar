import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.vanniktech.maven.publish)
    alias(libs.plugins.gradleup.nmcp)
}

kotlin {
    android {
        namespace = "io.github.elyesmansour.floatingTabBar"
        compileSdk = 36
        minSdk = 21

        compilerOptions {
            jvmTarget = JvmTarget.JVM_11
        }
    }

    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain.dependencies {
            implementation(libs.compose.ui)
            implementation(libs.compose.material3)
            implementation(libs.compose.foundation)
            implementation(libs.compose.animation)
            implementation(libs.compose.runtime)
        }
    }
}

mavenPublishing {
    publishToMavenCentral()
    signAllPublications()

    coordinates("io.github.elyesmansour", "floatingTabBar", "1.1.0-SNAPSHOT")

    pom {
        name = "FloatingTabBar"
        description = "A Compose Multiplatform floating tab bar that mimics the iOS 26 Liquid Glass tab bar behavior"
        url = "https://github.com/elyesmansour/compose-floating-tab-bar"
        licenses {
            license {
                name = "The Apache License, Version 2.0"
                url = "http://www.apache.org/licenses/LICENSE-2.0.txt"
                distribution = "http://www.apache.org/licenses/LICENSE-2.0.txt"
            }
        }
        developers {
            developer {
                name = "Elyes Mansour"
                email = "27696255+elyesmansour@users.noreply.github.com"
                url = "https://github.com/elyesmansour"
            }
        }
        scm {
            connection = "scm:git:git://github.com/elyesmansour/compose-floating-tab-bar.git"
            developerConnection = "scm:git:ssh://github.com/elyesmansour/compose-floating-tab-bar.git"
            url = "https://github.com/elyesmansour/compose-floating-tab-bar"
        }
    }
}
