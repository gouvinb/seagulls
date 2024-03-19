package io.github.gouvinb.seagulls.lib.core.data.repository

import io.github.gouvinb.seagulls.lib.core.datastore.model.local.DarkThemeConfigLocal
import io.github.gouvinb.seagulls.lib.core.datastore.model.local.ThemeBrandLocal
import io.github.gouvinb.seagulls.lib.core.datastore.model.local.UserDataLocal
import kotlinx.coroutines.flow.Flow

interface UserDataRepository {
    /**
     * Stream of [UserDataLocal]
     */
    val userDataStream: Flow<UserDataLocal>

    suspend fun setThemeBrand(themeBrand: ThemeBrandLocal)

    suspend fun setDarkThemeConfig(darkThemeConfig: DarkThemeConfigLocal)

    suspend fun setShouldHideOnboarding(shouldHideOnboarding: Boolean)
}
