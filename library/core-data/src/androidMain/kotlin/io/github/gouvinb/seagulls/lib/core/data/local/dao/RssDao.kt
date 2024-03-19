package io.github.gouvinb.seagulls.lib.core.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.github.gouvinb.seagulls.lib.core.data.local.model.RssLocal
import kotlinx.coroutines.flow.Flow

@Dao
interface RssDao {
    @Query("SELECT * FROM rss")
    fun getAll(): Flow<List<RssLocal>>

    @Query("SELECT * FROM rss WHERE link = :url")
    fun get(url: String): Flow<RssLocal?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(item: RssLocal)

    @Delete
    suspend fun delete(item: RssLocal)
}
