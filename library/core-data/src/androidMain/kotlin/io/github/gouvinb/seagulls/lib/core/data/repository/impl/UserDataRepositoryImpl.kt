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
