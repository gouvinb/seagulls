package io.github.gouvinb.seagulls.lib.core.ui.mapper

import io.github.gouvinb.seagulls.lib.core.domain.model.RssDomain
import io.github.gouvinb.seagulls.lib.core.ui.model.RssUi

object RssUiMapper {
    fun mapFromDomain(item: RssDomain) = RssUi.RssBasicUi(
        title = item.title,
        link = item.link,
        description = item.description,
    )

    fun mapToDomain(item: RssUi) = RssDomain(
        title = item.title,
        link = item.link,
        description = item.description,
    )
}
