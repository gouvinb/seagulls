package io.github.gouvinb.seagulls.lib.core.data.repository.impl

import io.github.gouvinb.seagulls.lib.core.data.repository.UserDataRepository
import io.github.gouvinb.seagulls.lib.core.datastore.UserPreferencesDataSource
import io.github.gouvinb.seagulls.lib.core.datastore.model.local.DarkThemeConfigLocal
import io.github.gouvinb.seagulls.lib.core.datastore.model.local.ThemeBrandLocal
import io.github.gouvinb.seagulls.lib.core.datastore.model.local.UserDataLocal
import kotlinx.coroutines.flow.Flow

class UserDataRepositoryImpl(
    private val userPreferencesDataSource: UserPreferencesDataSource,
) : UserDataRepository {
    override val userDataStream: Flow<UserDataLocal> =
        userPreferencesDataSource.userDataStream

    override suspend fun setShouldHideOnboarding(shouldHideOnboarding: Boolean) =
        userPreferencesDataSource.setShouldHideOnboarding(shouldHideOnboarding)

    override suspend fun setThemeBrand(themeBrand: ThemeBrandLocal) =
        userPreferencesDataSource.setThemeBrand(themeBrand)

    override suspend fun setDarkThemeConfig(darkThemeConfig: DarkThemeConfigLocal) =
        userPreferencesDataSource.setDarkThemeConfig(darkThemeConfig)
}
