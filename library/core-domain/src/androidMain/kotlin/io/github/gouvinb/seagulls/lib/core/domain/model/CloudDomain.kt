package io.github.gouvinb.seagulls.lib.core.domain.model

data class CloudDomain(
    val domain: String,
    val port: String,
    val path: String,
    val registerProcedure: String,
    val protocol: String,
)
