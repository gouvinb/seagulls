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
package io.github.gouvinb.seagulls.lib.core.data.local.model

import androidx.room.Embedded
import androidx.room.Entity

// TODO: 04/03/2024: add categories, and entries support
@Entity(primaryKeys = ["title", "description", "link"])
data class ChannelLocal(
    val title: String,
    val description: String,
    val link: String,
    val language: String?,
    val copyright: String?,
    val managingEditor: String?,
    val webMaster: String?,
    val pubDate: String?,
    val lastBuildDate: String?,
    // val categories: List<String>?,
    val generator: String?,
    val docs: String?,
    @Embedded(prefix = "cloud_") val cloud: CloudLocal?,
    val ttl: String?,
    @Embedded(prefix = "image_") val image: ImageLocal?,
    val rating: String?,
    @Embedded(prefix = "textInput_") val textInput: TextInputLocal?,
    val skipHours: String?,
    val skipDays: String?,
    // val items: List<ItemRemote>?,
)
