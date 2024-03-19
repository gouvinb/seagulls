package io.github.gouvinb.seagulls.feature.home.di

import io.github.gouvinb.seagulls.feature.home.ui.viewmodel.HomeViewModel
import io.github.gouvinb.seagulls.lib.core.data.di.dataModule
import io.github.gouvinb.seagulls.lib.core.domain.di.domainModule
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val homeModule = module {
    includes(domainModule, dataModule)
    viewModelOf(::HomeViewModel)
}
