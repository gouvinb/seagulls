package io.github.gouvinb.seagulls.feature.search.di

import io.github.gouvinb.seagulls.feature.search.ui.viewmodel.SearchViewModel
import io.github.gouvinb.seagulls.lib.core.data.di.dataModule
import io.github.gouvinb.seagulls.lib.core.domain.di.domainModule
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val searchModule = module {
    includes(domainModule, dataModule)
    viewModelOf(::SearchViewModel)
}
