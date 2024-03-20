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
        ),
    )

    fun mapToDataRemote(item: RssDomain) = RssRemoteMapper.mapToRemote(mapToDataLocal(item))
}
