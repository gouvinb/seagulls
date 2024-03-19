package io.github.gouvinb.seagulls.lib.core.domain.mapper

import io.github.gouvinb.seagulls.lib.core.data.local.model.ChannelLocal
import io.github.gouvinb.seagulls.lib.core.data.local.model.RssLocal
import io.github.gouvinb.seagulls.lib.core.data.remote.mapper.RssRemoteMapper
import io.github.gouvinb.seagulls.lib.core.domain.model.RssDomain

object RssDomainMapper {
    fun mapFromDataLocal(rssLocal: RssLocal) =
        RssDomain(
            title = rssLocal.channel.title,
            description = rssLocal.channel.description,
            link = rssLocal.channel.link,
            language = rssLocal.channel.language,
            copyright = rssLocal.channel.copyright,
            managingEditor = rssLocal.channel.managingEditor,
            webMaster = rssLocal.channel.webMaster,
            pubDate = rssLocal.channel.pubDate,
            lastBuildDate = rssLocal.channel.lastBuildDate,
            generator = rssLocal.channel.generator,
            docs = rssLocal.channel.docs,
            cloud = rssLocal.channel.cloud?.let { cloudLocal -> CloudDomainMapper.mapFromDataLocal(cloudLocal) },
            ttl = rssLocal.channel.ttl,
            image = rssLocal.channel.image?.let { imageLocal -> ImageDomainMapper.mapFromDataLocal(imageLocal) },
            rating = rssLocal.channel.rating,
            textInput = rssLocal.channel.textInput?.let { textInputLocal -> TextInputDomainMapper.mapFromDataLocal(textInputLocal) },
            skipHours = rssLocal.channel.skipHours,
            skipDays = rssLocal.channel.skipDays,
        )

    fun mapToDataLocal(rssDomain: RssDomain) = RssLocal(
        ChannelLocal(
            title = rssDomain.title,
            description = rssDomain.description,
            link = rssDomain.link,
            language = rssDomain.language,
            copyright = rssDomain.copyright,
            managingEditor = rssDomain.managingEditor,
            webMaster = rssDomain.webMaster,
            pubDate = rssDomain.pubDate,
            lastBuildDate = rssDomain.lastBuildDate,
            generator = rssDomain.generator,
            docs = rssDomain.docs,
            cloud = rssDomain.cloud?.let { CloudDomainMapper.mapToDataLocal(it) },
            ttl = rssDomain.ttl,
            image = rssDomain.image?.let { ImageDomainMapper.mapToDataLocal(it) },
            rating = rssDomain.rating,
            textInput = rssDomain.textInput?.let { TextInputDomainMapper.mapToDataLocal(it) },
            skipHours = rssDomain.skipHours,
            skipDays = rssDomain.skipDays,
        )
    )

    fun mapToDataRemote(item: RssDomain) = RssRemoteMapper.mapToRemote(mapToDataLocal(item))
}
