package io.github.gouvinb.seagulls.lib.core.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class ImageRemote(
    val url: String?,
    val title: String?,
    val link: String?,
    val width: String?,
    val height: String?,
)
