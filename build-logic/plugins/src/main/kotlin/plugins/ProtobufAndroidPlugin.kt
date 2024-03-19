package plugins

import com.google.protobuf.gradle.ProtobufExtension
import com.google.protobuf.gradle.id
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import utils.extenstion.getLibrary
import utils.extenstion.getPlugin
import utils.extenstion.libs

class ProtobufPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(libs.getPlugin("protobuf").pluginId)
            }

            extensions.configure<ProtobufExtension> {
                protoc {
                    artifact = libs.getLibrary("protobuf-protoc").toString()
                }
                generateProtoTasks {
                    all().forEach { task ->
                        task.builtins {
                            register("kotlin") {
                                option("lite")
                            }
                            register("java") {
                                option("lite")
                            }
                        }
                    }
                }
            }

            dependencies {
                add("implementation", libs.getLibrary("protobuf-kotlin-lite"))
                add("implementation", libs.getLibrary("protobuf-protoc"))
            }
        }
    }
}
