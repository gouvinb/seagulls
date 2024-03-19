package io.github.gouvinb.seagulls.lib.core.data.remote.mapper

import io.github.gouvinb.seagulls.lib.core.data.local.model.CloudLocal
import io.github.gouvinb.seagulls.lib.core.data.local.model.TextInputLocal
import io.github.gouvinb.seagulls.lib.core.data.remote.model.CloudRemote
import io.github.gouvinb.seagulls.lib.core.data.remote.model.ImageRemote
import io.github.gouvinb.seagulls.lib.core.data.remote.model.TextInputRemote

object TextInputRemoteMapper {
    fun mapToRemote(textInputLocal: TextInputLocal) = TextInputRemote(
        title = textInputLocal.title,
        description = textInputLocal.description,
        name = textInputLocal.name,
        link = textInputLocal.link,
    )
}
