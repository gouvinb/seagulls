package io.github.gouvinb.seagulls.ui

import io.github.gouvinb.seagulls.feature.bookmarks.di.bookmarksModule
import io.github.gouvinb.seagulls.feature.home.di.homeModule
import io.github.gouvinb.seagulls.feature.search.di.searchModule
import io.github.gouvinb.seagulls.feature.stand.di.standModule
import io.github.gouvinb.seagulls.lib.core.data.di.dataModule
import io.github.gouvinb.seagulls.ui.viewmodel.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    includes(
        dataModule,

        bookmarksModule,
        homeModule,
        searchModule,
        standModule,
    )

    viewModelOf(::MainActivityViewModel)
}
