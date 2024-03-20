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
package io.github.gouvinb.seagulls.lib.core.data.repository

import io.github.gouvinb.seagulls.lib.core.State
import io.github.gouvinb.seagulls.lib.core.data.local.model.RssLocal
import io.github.gouvinb.seagulls.lib.core.data.remote.model.RssRemote
import kotlinx.coroutines.flow.Flow

interface RssRepository {
    fun getRssList(): Flow<List<RssLocal>>

    fun getRss(url: String): Flow<RssLocal?>

    suspend fun saveRss(rssLocal: RssLocal)

    suspend fun deleteRss(rssLocal: RssLocal)

    suspend fun updateRss(rssLocal: RssLocal)

    suspend fun fetchDataLocal(rssLocal: RssLocal): Flow<State>

    suspend fun fetchDataRemote(rssRemote: RssRemote): Flow<State>
}
