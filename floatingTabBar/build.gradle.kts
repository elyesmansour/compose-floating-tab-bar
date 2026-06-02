plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.vanniktech.maven.publish)
    alias(libs.plugins.gradleup.nmcp)
}

android {
    namespace = "io.github.elyesmansour.floatingTabBar"
    compileSdk = 36

    defaultConfig {
        minSdk = 21

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true
    }
}

mavenPublishing {
    publishToMavenCentral()
    signAllPublications()

    coordinates("io.github.elyesmansour", "floatingTabBar", "1.0.1")

    pom {
        name = "FloatingTabBar"
        description = "A Jetpack Compose floating tab bar that mimics the iOS 26 Liquid Glass tab bar behavior"
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

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.material3)
}