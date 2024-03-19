package io.github.gouvinb.seagulls.lib.core.data.di

import androidx.room.Room
import io.github.gouvinb.seagulls.lib.core.data.local.RssDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val daosModule = module {
    includes(databaseModule)

    single { get<RssDatabase>().rssDao() }
}
