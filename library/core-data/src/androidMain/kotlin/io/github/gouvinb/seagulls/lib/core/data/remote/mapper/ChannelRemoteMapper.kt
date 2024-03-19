package io.github.gouvinb.seagulls.lib.core.data.remote.mapper

import io.github.gouvinb.seagulls.lib.core.data.local.model.ChannelLocal
import io.github.gouvinb.seagulls.lib.core.data.remote.model.ChannelRemote

object ChannelRemoteMapper {
    fun mapToRemote(channelLocal: ChannelLocal) = ChannelRemote(
        title = channelLocal.title,
                description = channelLocal.description,
                link = channelLocal.link,
                language = channelLocal.language,
                copyright = channelLocal.copyright,
                managingEditor = channelLocal.managingEditor,
                webMaster = channelLocal.webMaster,
                pubDate = channelLocal.pubDate,
                lastBuildDate = channelLocal.lastBuildDate,
                generator = channelLocal.generator,
                docs = channelLocal.docs,
                cloud = channelLocal.cloud?.let { cloudLocal -> CloudRemoteMapper.mapToRemote(cloudLocal) },
                ttl = channelLocal.ttl,
                image = channelLocal.image?.let { imageLocal -> ImageRemoteMapper.mapToRemote(imageLocal) },
                rating = channelLocal.rating,
                textInput = channelLocal.textInput?.let { textInputLocal -> TextInputRemoteMapper.mapToRemote(textInputLocal) },
                skipHours = channelLocal.skipHours,
                skipDays = channelLocal.skipDays,
    )
}
