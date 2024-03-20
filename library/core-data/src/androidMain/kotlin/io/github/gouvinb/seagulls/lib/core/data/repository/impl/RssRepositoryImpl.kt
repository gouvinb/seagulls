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
package io.github.gouvinb.seagulls.lib.core.data.repository.impl

import io.github.gouvinb.seagulls.lib.core.State
import io.github.gouvinb.seagulls.lib.core.data.local.dao.RssDao
import io.github.gouvinb.seagulls.lib.core.data.local.mapper.RssLocalMapper
import io.github.gouvinb.seagulls.lib.core.data.local.model.RssLocal
import io.github.gouvinb.seagulls.lib.core.data.remote.model.RssRemote
import io.github.gouvinb.seagulls.lib.core.data.repository.RssRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.flow

class RssRepositoryImpl(
    private val httpClient: HttpClient,
    private val rssDao: RssDao,
) : RssRepository {

    override fun getRssList() = rssDao.getAll()

    override fun getRss(url: String) = rssDao.get(url)

    override suspend fun saveRss(rssLocal: RssLocal) {
        rssDao.save(rssLocal)
    }

    override suspend fun deleteRss(rssLocal: RssLocal) {
        rssDao.delete(rssLocal)
    }

    override suspend fun updateRss(rssLocal: RssLocal) {
        rssDao.save(rssLocal)
    }

    override suspend fun fetchDataLocal(rssLocal: RssLocal) = flow {
        emit(State.LOADING)
        rssLocal.channel?.link
            ?.let {
                emit(State.SUCCESS)
                rssDao.get(rssLocal.channel.link)
            }
            ?: emit(State.ERROR)
    }

    override suspend fun fetchDataRemote(rssRemote: RssRemote) = flow {
        emit(State.LOADING)
        rssRemote.channel?.link
            ?.let { link ->
                emit(State.SUCCESS)
                httpClient.get(link)
                    .body<RssRemote>()
                    .let { newRssRemote -> RssLocalMapper.mapToLocal(newRssRemote) }
                    ?.also { newRssLocal ->
                        saveRss(newRssLocal)
                    }
            }
            ?: emit(State.ERROR)
    }
}
