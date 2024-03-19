package io.github.gouvinb.seagulls.lib.core.domain.di

import io.github.gouvinb.seagulls.lib.core.data.di.dataModule
import io.github.gouvinb.seagulls.lib.core.domain.usecase.RssUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {
    includes(dataModule)

    factoryOf(::RssUseCase)
}
