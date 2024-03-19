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
