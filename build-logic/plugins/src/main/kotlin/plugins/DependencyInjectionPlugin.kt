package plugins

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.dependencies
import utils.extenstion.getLibrary
import utils.extenstion.getPlugin
import utils.extenstion.libs

abstract class DependencyInjectionPlugin : Plugin<Project> {
    lateinit var bom: Provider<MinimalExternalModuleDependency>

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(libs.getPlugin("ksp").pluginId)
            }

            bom = libs.findLibrary("koin-bom").get()

            dependencies {
                add("implementation", platform(bom))
                add("testImplementation", platform(bom))
            }
        }
    }
}

class DependencyInjectionKotlinPlugin : DependencyInjectionPlugin() {
    override fun apply(target: Project) {
        super.apply(target)

        with(target) {
            dependencies {
                add("implementation", platform(bom))
                add("implementation", libs.getLibrary("koin-core"))

                add("testImplementation", platform(bom))
                add("testImplementation", libs.getLibrary("koin-test"))
            }
        }
    }
}

open class DependencyInjectionAndroidPlugin : DependencyInjectionPlugin() {
    override fun apply(target: Project) {
        super.apply(target)

        with(target) {
            dependencies {
                add("implementation", libs.getLibrary("koin-android"))
                add("implementation", libs.getLibrary("koin-android-compat"))
                add("implementation", libs.getLibrary("koin-androidx-navigation"))
                add("implementation", libs.getLibrary("koin-androidx-workmanager"))

                add("testImplementation", libs.getLibrary("koin-test-junit4"))
            }
        }
    }
}

class DependencyInjectionAndroidComposePlugin : DependencyInjectionAndroidPlugin() {
    override fun apply(target: Project) {
        super.apply(target)

        with(target) {
            dependencies {
                add("implementation", libs.getLibrary("koin-androidx-compose"))
                add("implementation", libs.getLibrary("koin-androidx-compose-navigation"))
            }
        }
    }
}

