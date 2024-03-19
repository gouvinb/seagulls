package io.github.gouvinb.seagulls.lib.core.data.remote.mapper

import io.github.gouvinb.seagulls.lib.core.data.local.model.ImageLocal
import io.github.gouvinb.seagulls.lib.core.data.remote.model.ImageRemote

object ImageRemoteMapper {
    fun mapToRemote(imageLocal: ImageLocal) = ImageRemote(
        url = imageLocal.url,
        title = imageLocal.title,
        link = imageLocal.link,
        width = imageLocal.width,
        height = imageLocal.height,
    )
}
