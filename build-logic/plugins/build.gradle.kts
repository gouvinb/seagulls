plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

group = "io.github.kotlin.multiplatform.template.gradle"

dependencies {
    implementation(libs.gradlePlugin.android)
    implementation(libs.gradlePlugin.androidx.room)
    implementation(libs.gradlePlugin.kotlin)
    implementation(libs.gradlePlugin.protobuf)
    implementation(libs.gradlePlugin.spotless)
}

gradlePlugin {
    plugins {
        // register("javaApplication") {
        //     id = "application.java"
        //     implementationClass = "application.JavaApplicationPlugin"
        // }

        // Android
        register("androidApplication") {
            id = "plugins.android.application"
            implementationClass = "plugins.AndroidApplicationPlugin"
        }
        register("androidLibrary") {
            id = "plugins.android.library"
            implementationClass = "plugins.AndroidLibraryPlugin"
        }

        register("androidComposeApplication") {
            id = "plugins.android.application.compose"
            implementationClass = "plugins.AndroidComposeApplicationPlugin"
        }
        register("androidComposeLibrary") {
            id = "plugins.android.library.compose"
            implementationClass = "plugins.AndroidComposeLibraryPlugin"
        }

        // Androidx
        register("androidxRoom") {
            id = "plugins.androidx.room"
            implementationClass = "plugins.AndroidxRoomPlugin"
        }

        // Compile
        register("compileJava") {
            id = "plugins.compile.java"
            implementationClass = "plugins.CompileJavaPlugin"
        }
        register("compileKotlin") {
            id = "plugins.compile.kotlin"
            implementationClass = "plugins.CompileKotlinPlugin"
        }

        // Dependency Injection
        register("dependencyInjectionKotlin") {
            id = "plugins.di.kotlin"
            implementationClass = "plugins.DependencyInjectionKotlinPlugin"
        }
        register("dependencyInjectionAndroid") {
            id = "plugins.di.android"
            implementationClass = "plugins.DependencyInjectionAndroidPlugin"
        }
        register("dependencyInjectionAndroidCompose") {
            id = "plugins.di.android.compose"
            implementationClass = "plugins.DependencyInjectionAndroidComposePlugin"
        }

        // Protobuf
        register("protobufPlugin") {
            id = "plugins.protobuf"
            implementationClass = "plugins.ProtobufPlugin"
        }

        // Spotless
        register("javaSpotless") {
            id = "plugins.spotless.java"
            implementationClass = "plugins.SpotlessJavaPlugin"
        }
        register("androidSpotless") {
            id = "plugins.spotless.android"
            implementationClass = "plugins.SpotlessAndroidPlugin"
        }

        // Test
        register("test") {
            id = "plugins.test"
            implementationClass = "plugins.TestPlugin"
        }
    }
}
