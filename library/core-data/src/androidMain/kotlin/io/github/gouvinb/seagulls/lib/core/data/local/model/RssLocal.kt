package io.github.gouvinb.seagulls.lib.core.data.local.model

import androidx.room.Embedded
import androidx.room.Entity


@Entity(tableName = "rss", primaryKeys = ["title", "description", "link"])
data class RssLocal(
    @Embedded val channel: ChannelLocal,
)
