plugins {
    id("com.android.library")
    `maven-publish`
    signing
    alias(libs.plugins.kotlin.compose)
    id("com.vanniktech.maven.publish") version "0.36.0"
}

android {
    namespace = "io.github.sathiyalingesh.uilib"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}

mavenPublishing {
    publishToMavenCentral()

    signAllPublications()

    coordinates(group.toString(), "ui_lib_v1", version.toString())

    pom {
        name = "UI Library"
        description = "A Kotlin UI library for Android."
        inceptionYear = "2026"
        url = "https://github.com/sathiyalingesh/ui_lib.git"
        licenses {
            license {
                name = "The Apache License, Version 2.0"
                url = "https://www.apache.org/licenses/LICENSE-2.0.txt"
                distribution = "https://www.apache.org/licenses/LICENSE-2.0.txt"
            }
        }
        developers {
            developer {
                id = "sathiyalingesh"
                name = "Sathiya Lingesh"
                url = "https://github.com/sathiyalingesh/"
            }
        }
        scm {
            url = "https://github.com/sathiyalingesh/ui_lib.git"
            connection = "scm:git:git://github.com/sathiyalingesh/ui_lib.git"
            developerConnection = "scm:git:ssh://git@github.com/sathiyalingesh/ui_lib.git"
        }
    }
}