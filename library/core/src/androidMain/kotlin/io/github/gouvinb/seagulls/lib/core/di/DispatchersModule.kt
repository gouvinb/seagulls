package io.github.gouvinb.seagulls.lib.core.di


import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val dispatchersModule = module {
    single { Dispatchers.IO }
}
