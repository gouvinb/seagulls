package io.github.gouvinb.seagulls.lib.core.data.di

import io.github.gouvinb.seagulls.lib.core.data.repository.RssRepository
import io.github.gouvinb.seagulls.lib.core.data.repository.impl.RssRepositoryImpl
import io.github.gouvinb.seagulls.lib.core.HttpClientImpl
import io.github.gouvinb.seagulls.lib.core.data.repository.UserDataRepository
import io.github.gouvinb.seagulls.lib.core.data.repository.impl.UserDataRepositoryImpl
import io.github.gouvinb.seagulls.lib.core.datastore.di.dataStoreModule
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataModule = module {
    includes(daosModule, dataStoreModule, httpClientModule)

    singleOf(::HttpClientImpl)
    singleOf(::RssRepositoryImpl) { bind<RssRepository>() }
    singleOf(::UserDataRepositoryImpl) { bind<UserDataRepository>() }
}
