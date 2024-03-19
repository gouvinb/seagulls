package io.github.gouvinb.seagulls.feature.bookmarks.di

import io.github.gouvinb.seagulls.feature.bookmarks.ui.viewmodel.BookmarksViewModel
import io.github.gouvinb.seagulls.lib.core.data.di.dataModule
import io.github.gouvinb.seagulls.lib.core.domain.di.domainModule
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val bookmarksModule = module {
    includes(domainModule, dataModule)
    viewModelOf(::BookmarksViewModel)
}
