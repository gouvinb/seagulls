package io.github.gouvinb.seagulls.lib.core.data.local.model

import androidx.room.Embedded
import androidx.room.Entity

// TODO: 04/03/2024: add categories, and entries support
@Entity(primaryKeys = ["title", "description", "link"])
data class ChannelLocal(
    val title: String,
    val description: String,
    val link: String,
    val language: String?,
    val copyright: String?,
    val managingEditor: String?,
    val webMaster: String?,
    val pubDate: String?,
    val lastBuildDate: String?,
    // val categories: List<String>?,
    val generator: String?,
    val docs: String?,
    @Embedded(prefix = "cloud_") val cloud: CloudLocal?,
    val ttl: String?,
    @Embedded(prefix = "image_") val image: ImageLocal?,
    val rating: String?,
    @Embedded(prefix = "textInput_") val textInput: TextInputLocal?,
    val skipHours: String?,
    val skipDays: String?,
    // val items: List<ItemRemote>?,
)
