package io.github.gouvinb.seagulls.lib.core.data.local.mapper

import io.github.gouvinb.seagulls.lib.core.data.local.model.RssLocal
import io.github.gouvinb.seagulls.lib.core.data.remote.model.RssRemote

object RssLocalMapper {
    fun mapToLocal(rssRemote: RssRemote) = rssRemote.channel
        ?.let { channelRemote ->
            ChannelLocalMapper.mapToLocal(channelRemote)
                ?.let { channelLocal ->
                    RssLocal(channelLocal)
                }
        }
}
