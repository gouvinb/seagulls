/*
 * Copyright 2024 Gouvinb
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
