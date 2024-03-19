package io.github.gouvinb.seagulls.lib.core.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
// TODO: 04/03/2024: add categories, and entries support
data class ChannelRemote(
    val title: String?,
    val description: String?,
    val link: String?,
    val language: String?,
    val copyright: String?,
    val managingEditor: String?,
    val webMaster: String?,
    val pubDate: String?,
    val lastBuildDate: String?,
    // val categories: List<String>?,
    val generator: String?,
    val docs: String?,
    val cloud: CloudRemote?,
    val ttl: String?,
    val image: ImageRemote?,
    val rating: String?,
    val textInput: TextInputRemote?,
    val skipHours: String?,
    val skipDays: String?,
    // val items: List<ItemRemote>?,
)
