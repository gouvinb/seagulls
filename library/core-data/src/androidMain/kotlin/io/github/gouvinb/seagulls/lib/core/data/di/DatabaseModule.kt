package io.github.gouvinb.seagulls.lib.core.data.di

import androidx.room.Room
import io.github.gouvinb.seagulls.lib.core.data.local.RssDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            RssDatabase::class.java,
            "rss-database"
        ).build()
    }
}
