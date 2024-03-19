package io.github.gouvinb.seagulls.lib.core.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class RssRemote(
    val channel: ChannelRemote?,
)
