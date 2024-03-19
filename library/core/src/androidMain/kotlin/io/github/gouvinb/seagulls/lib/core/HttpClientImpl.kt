package io.github.gouvinb.seagulls.lib.core

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpRequestRetry
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.xml.xml
import nl.adaptivity.xmlutil.serialization.XML

class HttpClientImpl(
    networkXml: XML,
    isDebug: Boolean,
) {
    val httpClient = HttpClient {
        install(Logging) {
            logger = Logger.DEFAULT
            level = if (isDebug) LogLevel.ALL else LogLevel.NONE
        }

        install(HttpRequestRetry) {
            retryOnServerErrors(maxRetries = 5)
            exponentialDelay()
        }

        install(ContentNegotiation) {
            xml(format = networkXml)
        }

        expectSuccess = true
    }
}
