package io.github.gouvinb.seagulls.lib.core.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class TextInputRemote(
    val title: String?,
    val description: String?,
    val name: String?,
    val link: String?,
)
