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
import com.google.protobuf.gradle.proto
import utils.extenstion.configureOrCreateNativePlatforms
import utils.extenstion.configureSourceSetHierarchy
import java.util.Locale

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("plugins.android.library")
    alias(libs.plugins.kotlin.multiplatform)

    id("plugins.di.kotlin")
    id("plugins.di.android")

    id("plugins.compile.java")
    id("plugins.compile.kotlin")
    id("plugins.test")

    id("plugins.protobuf")

    id("plugins.spotless.android")
}

group = "io.github.gouvinb.seagulls.lib.core.datastore"
version = "0.1.0"

android {
    namespace = group.toString()

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    sourceSets {
        getByName("main") {
            proto {
                srcDir("src/android${this@getByName.name.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }}/proto")
            }
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
    commonMainImplementation(libs.kotlinx.coroutines.android)

    commonMainImplementation(libs.androidx.dataStore.core)

    commonMainImplementation(projects.seagulls.library.core)
}
