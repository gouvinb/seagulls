package io.github.gouvinb.seagulls.lib.core.data.remote.mapper

import io.github.gouvinb.seagulls.lib.core.data.local.model.RssLocal
import io.github.gouvinb.seagulls.lib.core.data.remote.model.RssRemote

object RssRemoteMapper {
    fun mapToRemote(rssLocal: RssLocal) = RssRemote(channel = rssLocal.channel?.let { ChannelRemoteMapper.mapToRemote(it) })
}
