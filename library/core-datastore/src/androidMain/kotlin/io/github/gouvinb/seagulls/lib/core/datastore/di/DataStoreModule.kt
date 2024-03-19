package io.github.gouvinb.seagulls.lib.core.datastore.di

import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import io.github.gouvinb.seagulls.lib.core.datastore.UserPreferencesDataSource
import io.github.gouvinb.seagulls.lib.core.datastore.serializer.UserPreferencesSerializer
import io.github.gouvinb.seagulls.lib.core.di.dispatchersModule
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataStoreModule = module {
    includes(dispatchersModule)

    singleOf(::UserPreferencesSerializer)
    single {
        DataStoreFactory.create(
            serializer = get<UserPreferencesSerializer>(),
            scope = CoroutineScope(get<CoroutineDispatcher>() + SupervisorJob()),
            migrations = listOf()
        ) {
            androidContext().dataStoreFile("user_preferences.pb")
        }
    }
    singleOf(::UserPreferencesDataSource)
}
