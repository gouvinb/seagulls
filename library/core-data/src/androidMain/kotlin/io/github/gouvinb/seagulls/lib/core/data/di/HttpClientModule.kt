package io.github.gouvinb.seagulls.lib.core.data.di

import nl.adaptivity.xmlutil.XmlDeclMode
import nl.adaptivity.xmlutil.serialization.XML
import org.koin.core.module.dsl.singleOf
import io.github.gouvinb.seagulls.lib.core.HttpClientImpl
import io.github.gouvinb.seagulls.lib.core.data.BuildConfig
import org.koin.dsl.module

val httpClientModule = module {
    singleOf(::HttpClientImpl)

    single {
        XML { xmlDeclMode = XmlDeclMode.Charset }
    }
    single {
        BuildConfig.DEBUG
    }
}
