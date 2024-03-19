package io.github.gouvinb.seagulls.feature.stand.di

import io.github.gouvinb.seagulls.feature.stand.ui.viewmodel.StandViewModel
import io.github.gouvinb.seagulls.lib.core.data.di.dataModule
import io.github.gouvinb.seagulls.lib.core.domain.di.domainModule
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val standModule = module {
    includes(domainModule, dataModule)
    viewModelOf(::StandViewModel)
}
