/*
 * Copyright 2024 Gouvinb
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
