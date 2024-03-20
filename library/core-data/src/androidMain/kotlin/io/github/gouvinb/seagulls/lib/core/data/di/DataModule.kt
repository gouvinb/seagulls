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
package io.github.gouvinb.seagulls.lib.core.data.di

import io.github.gouvinb.seagulls.lib.core.HttpClientImpl
import io.github.gouvinb.seagulls.lib.core.data.repository.RssRepository
import io.github.gouvinb.seagulls.lib.core.data.repository.UserDataRepository
import io.github.gouvinb.seagulls.lib.core.data.repository.impl.RssRepositoryImpl
import io.github.gouvinb.seagulls.lib.core.data.repository.impl.UserDataRepositoryImpl
import io.github.gouvinb.seagulls.lib.core.data.util.NetworkMonitor
import io.github.gouvinb.seagulls.lib.core.data.util.impl.ConnectivityManagerNetworkMonitor
import io.github.gouvinb.seagulls.lib.core.datastore.di.dataStoreModule
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataModule = module {
    includes(daosModule, dataStoreModule, httpClientModule)

    singleOf(::HttpClientImpl)
    singleOf(::RssRepositoryImpl) { bind<RssRepository>() }
    singleOf(::UserDataRepositoryImpl) { bind<UserDataRepository>() }
    singleOf(::ConnectivityManagerNetworkMonitor) { bind<NetworkMonitor>() }
}
