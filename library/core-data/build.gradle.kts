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
    id("plugins.android.library")
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlinx.serialization)

    id("plugins.android.library.compose")
    id("plugins.androidx.room")
    id("plugins.di.kotlin")
    id("plugins.di.android")
    id("plugins.di.android.compose")

    id("plugins.compile.java")
    id("plugins.compile.kotlin")
    id("plugins.test")

    id("plugins.spotless.android")
}

group = "io.github.gouvinb.seagulls.lib.core.data"
version = "0.1.0"

android {
    namespace = group.toString()

    buildFeatures {
        buildConfig = true
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
    }
}

dependencies {
    commonMainImplementation(libs.ktor.client.core)
    commonMainImplementation(libs.ktor.client.content.negotiation)
    commonMainImplementation(libs.ktor.serialization.kotlinx.xml)

    "kspAndroid"(libs.androidx.room.compiler)

    "androidMainImplementation"(libs.ktor.client.okhttp)

    "androidMainImplementation"(projects.seagulls.library.core)
    "androidMainImplementation"(projects.seagulls.library.coreDatastore)
}
