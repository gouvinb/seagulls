/*
 * Copyright 2024 Gouvinb
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import utils.extenstion.configureOrCreateNativePlatforms
import utils.extenstion.configureSourceSetHierarchy

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("plugin.android.library")
    kotlin("multiplatform")

    id("plugin.android.library.compose")

    id("plugins.compile.java")
    id("plugins.compile.kotlin")
    id("plugins.test")

    id("plugins.spotless.android")
}

group = "io.github.gouvinb.seagulls.lib.ui"
version = "0.1.0"

android {
    namespace = group.toString()

    buildFeatures {
        compose = true
    }

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
}

kotlin {
    configureOrCreateNativePlatforms(
        enableAndroidProject = true,
    )
    sourceSets {
        configureSourceSetHierarchy(
            enableAndroidProject = true,
        )

        val androidMain by getting {
            dependencies {
                implementation(libs.androidx.activity.compose)

                implementation(libs.androidx.compose.foundation)
                implementation(libs.androidx.compose.material3)
                implementation(libs.androidx.compose.runtime)
                implementation(libs.androidx.compose.ui.tooling)
                implementation(libs.androidx.compose.ui.tooling.preview)
            }
        }
        val androidUnitTest by getting {}
        val androidInstrumentedTest by getting {}
    }
}
