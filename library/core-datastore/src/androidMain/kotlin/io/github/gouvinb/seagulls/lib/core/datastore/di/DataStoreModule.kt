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
package io.github.gouvinb.seagulls.lib.core.datastore.di

import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import io.github.gouvinb.seagulls.lib.core.datastore.UserPreferencesDataSource
import io.github.gouvinb.seagulls.lib.core.datastore.serializer.UserPreferencesSerializer
import io.github.gouvinb.seagulls.lib.core.di.dispatchersModule
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataStoreModule = module {
    includes(dispatchersModule)

    singleOf(::UserPreferencesSerializer)
    single {
        DataStoreFactory.create(
            serializer = get<UserPreferencesSerializer>(),
            scope = CoroutineScope(get<CoroutineDispatcher>() + SupervisorJob()),
            migrations = listOf()
        ) {
            androidContext().dataStoreFile("user_preferences.pb")
        }
    }
    singleOf(::UserPreferencesDataSource)
}
