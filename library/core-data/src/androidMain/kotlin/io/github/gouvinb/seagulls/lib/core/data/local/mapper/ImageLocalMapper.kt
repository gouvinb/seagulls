package io.github.gouvinb.seagulls.lib.core.data.local.mapper

import io.github.gouvinb.seagulls.lib.core.data.local.model.ImageLocal
import io.github.gouvinb.seagulls.lib.core.data.remote.model.ImageRemote

object ImageLocalMapper {
    fun mapToLocal(imageRemote: ImageRemote) = ImageLocal(
        url = imageRemote.url,
        title = imageRemote.title,
        link = imageRemote.link,
        width = imageRemote.width,
        height = imageRemote.height,
    )
}
