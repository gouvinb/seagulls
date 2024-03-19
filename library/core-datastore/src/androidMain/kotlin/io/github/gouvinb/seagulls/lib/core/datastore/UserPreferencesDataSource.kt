package io.github.gouvinb.seagulls.lib.core.datastore

import androidx.datastore.core.DataStore
import io.github.gouvinb.seagulls.lib.core.datastore.model.local.DarkThemeConfigLocal
import io.github.gouvinb.seagulls.lib.core.datastore.model.local.ThemeBrandLocal
import io.github.gouvinb.seagulls.lib.core.datastore.model.local.UserDataLocal
import io.github.gouvinb.seagulls.lib.core.datastore.model.proto.*
import kotlinx.coroutines.flow.map


class UserPreferencesDataSource(
    private val userPreferences: DataStore<UserPreferencesProto>,
) {

    val userDataStream = userPreferences.data
        .map {
            UserDataLocal(
                shouldHideOnboarding = it.shouldHideOnboarding,
                themeBrand = when (it.themeBrand) {
                    null,
                    ThemeBrandProto.THEME_BRAND_UNSPECIFIED,
                    ThemeBrandProto.UNRECOGNIZED,
                    ThemeBrandProto.THEME_BRAND_DEFAULT,
                    -> ThemeBrandLocal.DEFAULT
                },
                darkThemeConfig = when (it.darkThemeConfig) {
                    null,
                    DarkThemeConfigProto.DARK_THEME_CONFIG_UNSPECIFIED,
                    DarkThemeConfigProto.UNRECOGNIZED,
                    DarkThemeConfigProto.DARK_THEME_CONFIG_FOLLOW_SYSTEM,
                    -> DarkThemeConfigLocal.FOLLOW_SYSTEM
                    DarkThemeConfigProto.DARK_THEME_CONFIG_LIGHT -> DarkThemeConfigLocal.LIGHT
                    DarkThemeConfigProto.DARK_THEME_CONFIG_DARK -> DarkThemeConfigLocal.DARK
                },
            )
        }

    suspend fun setShouldHideOnboarding(shouldHideOnboarding: Boolean) {
        userPreferences.updateData {
            it.copy {
                this.shouldHideOnboarding = shouldHideOnboarding
            }
        }
    }

    suspend fun setThemeBrand(themeBrand: ThemeBrandLocal) {
        userPreferences.updateData {
            it.copy {
                this.themeBrand = when (themeBrand) {
                    ThemeBrandLocal.DEFAULT -> ThemeBrandProto.THEME_BRAND_DEFAULT
                }
            }
        }
    }

    suspend fun setDarkThemeConfig(darkThemeConfig: DarkThemeConfigLocal) {
        userPreferences.updateData {
            it.copy {
                this.darkThemeConfig = when (darkThemeConfig) {
                    DarkThemeConfigLocal.FOLLOW_SYSTEM -> DarkThemeConfigProto.DARK_THEME_CONFIG_FOLLOW_SYSTEM
                    DarkThemeConfigLocal.LIGHT -> DarkThemeConfigProto.DARK_THEME_CONFIG_LIGHT
                    DarkThemeConfigLocal.DARK -> DarkThemeConfigProto.DARK_THEME_CONFIG_DARK
                }
            }
        }
    }
}
