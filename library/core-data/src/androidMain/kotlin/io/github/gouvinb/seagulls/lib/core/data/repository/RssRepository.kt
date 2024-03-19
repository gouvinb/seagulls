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
