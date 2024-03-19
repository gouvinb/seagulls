package io.github.gouvinb.seagulls.lib.core.data.local.mapper

import io.github.gouvinb.seagulls.lib.core.data.local.model.TextInputLocal
import io.github.gouvinb.seagulls.lib.core.data.remote.model.TextInputRemote

object TextInputLocalMapper {
    fun mapToLocal(textInputRemote: TextInputRemote) = TextInputLocal(
        title = textInputRemote.title,
        description = textInputRemote.description,
        name = textInputRemote.name,
        link = textInputRemote.link,
    )
}
