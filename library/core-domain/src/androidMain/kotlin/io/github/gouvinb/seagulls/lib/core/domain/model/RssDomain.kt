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
package io.github.gouvinb.seagulls.lib.core.domain.model

data class RssDomain(
    val title: String,
    val description: String,
    val link: String,
    val language: String? = null,
    val copyright: String? = null,
    val managingEditor: String? = null,
    val webMaster: String? = null,
    val pubDate: String? = null,
    val lastBuildDate: String? = null,
    val generator: String? = null,
    val docs: String? = null,
    val cloud: CloudDomain? = null,
    val ttl: String? = null,
    val image: ImageDomain? = null,
    val rating: String? = null,
    val textInput: TextInputDomain? = null,
    val skipHours: String? = null,
    val skipDays: String? = null,
)
