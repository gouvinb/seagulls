package io.github.gouvinb.seagulls.lib.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import io.github.gouvinb.seagulls.lib.core.data.local.dao.RssDao
import io.github.gouvinb.seagulls.lib.core.data.local.model.RssLocal

@Database(
    entities = [
        RssLocal::class,
    ],
    version = 1,
    autoMigrations = [],
    exportSchema = true,
)
abstract class RssDatabase : RoomDatabase() {
    abstract fun rssDao(): RssDao
}
