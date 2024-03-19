package io.github.gouvinb.seagulls.lib.core.data.local.mapper

import io.github.gouvinb.seagulls.lib.core.data.local.model.ChannelLocal
import io.github.gouvinb.seagulls.lib.core.data.remote.model.ChannelRemote

object ChannelLocalMapper {
    fun mapToLocal(channelRemote: ChannelRemote) = channelRemote
        .takeIf {
            it.title?.isNotBlank() == true &&
            it.description?.isNotBlank() == true &&
            it.link?.isNotBlank() == true
        }
        ?.let {
            ChannelLocal(
                title = it.title!!,
                description = it.description!!,
                link = it.link!!,
                language = it.language,
                copyright = it.copyright,
                managingEditor = it.managingEditor,
                webMaster = it.webMaster,
                pubDate = it.pubDate,
                lastBuildDate = it.lastBuildDate,
                generator = it.generator,
                docs = it.docs,
                cloud = it.cloud?.let { cloudRemote -> CloudLocalMapper.mapToLocal(cloudRemote) },
                ttl = it.ttl,
                image = it.image?.let { imageRemote -> ImageLocalMapper.mapToLocal(imageRemote) },
                rating = it.rating,
                textInput = it.textInput?.let { textInputRemote -> TextInputLocalMapper.mapToLocal(textInputRemote) },
                skipHours = it.skipHours,
                skipDays = it.skipDays,
            )
        }
}
