package io.github.gouvinb.seagulls.lib.core.domain.usecase

import io.github.gouvinb.seagulls.lib.core.State
import io.github.gouvinb.seagulls.lib.core.data.repository.RssRepository
import io.github.gouvinb.seagulls.lib.core.domain.mapper.RssDomainMapper
import io.github.gouvinb.seagulls.lib.core.domain.model.RssDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull

class RssUseCase(private val rssRepository: RssRepository) {
    fun getFeedList(): Flow<List<RssDomain>> = rssRepository
        .getRssList()
        .mapNotNull { feedItemList ->
            feedItemList.mapNotNull { dataItem -> RssDomainMapper.mapFromDataLocal(dataItem) }
        }

    fun getFeedItem(url: String): Flow<RssDomain?> = rssRepository
        .getRss(url)
        .map { feedItem ->
            feedItem?.let { data -> RssDomainMapper.mapFromDataLocal(data) }
        }

    suspend fun saveFeedItem(feedItem: RssDomain) = rssRepository
        .saveRss(RssDomainMapper.mapToDataLocal(feedItem))

    suspend fun deleteFeedItem(feedItem: RssDomain) = rssRepository
        .deleteRss(RssDomainMapper.mapToDataLocal(feedItem))

    suspend fun updateFeedItem(feedItem: RssDomain) = rssRepository
        .updateRss(RssDomainMapper.mapToDataLocal(feedItem))

    suspend fun fetchDataLocal(feedItem: RssDomain): Flow<State> = rssRepository
        .fetchDataLocal(RssDomainMapper.mapToDataLocal(feedItem))

    suspend fun fetchDataRemote(feedItem: RssDomain): Flow<State> = rssRepository
        .fetchDataRemote(RssDomainMapper.mapToDataRemote(feedItem))
}
