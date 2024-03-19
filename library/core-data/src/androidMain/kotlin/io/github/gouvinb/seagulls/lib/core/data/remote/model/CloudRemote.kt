package io.github.gouvinb.seagulls.lib.core.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class CloudRemote(
    val domain: String?,
    val port: String?,
    val path: String?,
    val registerProcedure: String?,
    val protocol: String?,
)
