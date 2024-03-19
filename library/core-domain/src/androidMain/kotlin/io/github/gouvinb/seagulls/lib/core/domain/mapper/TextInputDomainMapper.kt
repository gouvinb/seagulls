package io.github.gouvinb.seagulls.lib.core.domain.mapper

import io.github.gouvinb.seagulls.lib.core.data.local.model.CloudLocal
import io.github.gouvinb.seagulls.lib.core.data.local.model.TextInputLocal
import io.github.gouvinb.seagulls.lib.core.data.remote.model.CloudRemote
import io.github.gouvinb.seagulls.lib.core.data.remote.model.TextInputRemote
import io.github.gouvinb.seagulls.lib.core.domain.model.CloudDomain
import io.github.gouvinb.seagulls.lib.core.domain.model.TextInputDomain

object TextInputDomainMapper {
    fun mapFromDataLocal(item: TextInputLocal) = item
        .takeIf {
            it.title?.isNotBlank() == true &&
                    it.description?.isNotBlank() == true &&
                    it.name?.isNotBlank() == true &&
                    it.link?.isNotBlank() == true
        }
        ?.let {
            TextInputDomain(
                title = it.title!!,
                description = it.description!!,
                name = it.name!!,
                link = it.link!!,
            )
        }

    fun mapToDataLocal(item: TextInputDomain) = TextInputLocal(
        title = item.title,
        description = item.description,
        name = item.name,
        link = item.link,
    )

    fun mapToDataRemote(item: TextInputDomain) = TextInputRemote(
        title = item.title,
        description = item.description,
        name = item.name,
        link = item.link,
    )
}
