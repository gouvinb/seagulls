package plugins

import com.diffplug.gradle.spotless.SpotlessExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import utils.extenstion.libs

abstract class SpotlessPlugin(private val isAndroidProject: Boolean) : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.diffplug.spotless")

            extensions.configure<SpotlessExtension> {
                kotlin {
                    target("**/*.kt")
                    targetExclude("**/build/**/*.kt")
                    ktlint(libs.findVersion("ktlint").get().toString())
                        .editorConfigOverride(
                            buildMap {
                                put("ktlint_code_style", if (isAndroidProject) "android_studio" else "intellij_idea")
                                put("android", if (isAndroidProject) "true" else "false")
                                if (isAndroidProject) {
                                    put("ij_kotlin_allow_trailing_comma", "true")
                                    put("ij_kotlin_allow_trailing_comma_on_call_site", "true")
                                    put("ktlint_function_naming_ignore_when_annotated_with", "Composable, Test")
                                    put("max_line_length", "off")
                                }
                            }
                        )
                    licenseHeaderFile(rootProject.file("spotless/copyright.kt"))
                }
                format("kts") {
                    target("**/*.kts")
                    targetExclude("**/build/**/*.kts")
                    // Look for the first line that doesn't have a block comment (assumed to be the license)
                    licenseHeaderFile(rootProject.file("spotless/copyright.kts"), "(^(?![\\/ ]\\*).*$)")
                }
                format("xml") {
                    target("**/*.xml")
                    targetExclude("**/build/**/*.xml")
                    // Look for the first XML tag that isn't a comment (<!--) or the xml declaration (<?xml)
                    licenseHeaderFile(rootProject.file("spotless/copyright.xml"), "(<[^!?])")
                }
            }
        }
    }
}

class SpotlessJavaPlugin : SpotlessPlugin(false)

class SpotlessAndroidPlugin : SpotlessPlugin(true)
