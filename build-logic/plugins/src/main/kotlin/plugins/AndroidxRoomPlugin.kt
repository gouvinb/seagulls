package plugins

import androidx.room.gradle.RoomExtension
import com.android.build.api.variant.AndroidComponentsExtension
import com.android.build.gradle.TestedExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import utils.extenstion.getPlugin
import utils.extenstion.libs
import kotlin.reflect.KClass

class AndroidxRoomPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(libs.getPlugin("androidx-room").pluginId)
                apply(libs.getPlugin("ksp").pluginId)
            }

            extensions.configure<RoomExtension> {
                schemaDirectory("$projectDir/schemas")
            }

            dependencies {
                add("implementation", libs.findLibrary("androidx-room-runtime").get())
                add("implementation", libs.findLibrary("androidx-room-ktx").get())
                add("implementation", libs.findLibrary("androidx-room-paging").get())
            }
        }
    }
}
