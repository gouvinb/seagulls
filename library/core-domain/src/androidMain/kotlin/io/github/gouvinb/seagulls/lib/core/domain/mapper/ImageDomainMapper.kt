package io.github.gouvinb.seagulls.lib.core.domain.mapper

import io.github.gouvinb.seagulls.lib.core.data.local.model.ImageLocal
import io.github.gouvinb.seagulls.lib.core.data.remote.model.ImageRemote
import io.github.gouvinb.seagulls.lib.core.domain.model.ImageDomain

object ImageDomainMapper {
    fun mapFromDataLocal(item: ImageLocal) = item
        .takeIf {
            it.url?.isNotBlank() == true &&
                    it.title?.isNotBlank() == true &&
                    it.link?.isNotBlank() == true
        }
        ?.let {
            ImageDomain(
                url = it.url!!,
                title = it.title!!,
                link = it.link!!,
                width = it.width,
                height = it.height,
            )
        }

    fun mapToDataLocal(item: ImageDomain) = ImageLocal(
        url = item.url,
        title = item.title,
        link = item.link,
        width = item.width,
        height = item.height,
    )

    fun mapToDataRemote(item: ImageDomain) = ImageRemote(
        url = item.url,
        title = item.title,
        link = item.link,
        width = item.width,
        height = item.height,
    )
}
