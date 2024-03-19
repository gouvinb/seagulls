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
    id("plugins.android.application")
    alias(libs.plugins.kotlin.multiplatform)

    id("plugins.android.application.compose")
    id("plugins.di.android")
    id("plugins.di.android.compose")

    id("plugins.compile.java")
    id("plugins.compile.kotlin")
    id("plugins.test")

    id("plugins.spotless.android")
}

group = "io.github.gouvinb.seagulls"
version = "0.1.0"

android {
    namespace = group.toString()

    buildFeatures {
        compose = true
        buildConfig = true
    }

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
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
    "androidMainImplementation"(libs.androidx.activity.compose)

    "androidMainImplementation"(libs.androidx.compose.foundation)
    "androidMainImplementation"(libs.androidx.compose.material)
    "androidMainImplementation"(libs.androidx.compose.material.iconsExtended)
    "androidMainImplementation"(libs.androidx.compose.material3)
    "androidMainImplementation"(libs.androidx.compose.navigationCompose)
    "androidMainImplementation"(libs.androidx.compose.runtime)
    "androidMainImplementation"(libs.androidx.compose.ui.tooling)
    "androidMainImplementation"(libs.androidx.compose.ui.tooling.preview)

    "androidMainImplementation"(libs.androidx.core.splashscreen)
    "androidMainImplementation"(libs.accompanist.systemuicontroller)

    "androidMainImplementation"(projects.seagulls.library.ui)

    "androidMainImplementation"(projects.seagulls.library.core)
    "androidMainImplementation"(projects.seagulls.library.coreData)
    "androidMainImplementation"(projects.seagulls.library.coreDatastore)
    "androidMainImplementation"(projects.seagulls.library.coreDomain)
    "androidMainImplementation"(projects.seagulls.library.coreUi)

    "androidMainImplementation"(projects.seagulls.feature.bookmarks)
    "androidMainImplementation"(projects.seagulls.feature.home)
    "androidMainImplementation"(projects.seagulls.feature.search)
    "androidMainImplementation"(projects.seagulls.feature.stand)
}
