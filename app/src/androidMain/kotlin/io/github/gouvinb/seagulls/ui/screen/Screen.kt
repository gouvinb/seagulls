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
package io.github.gouvinb.seagulls.ui.screen

import androidx.annotation.StringRes
import androidx.compose.material.icons.twotone.Bookmarks
import androidx.compose.material.icons.twotone.Category
import androidx.compose.material.icons.twotone.Home
import androidx.compose.material.icons.twotone.Search
import androidx.compose.ui.graphics.vector.ImageVector
import io.github.gouvinb.seagulls.lib.ui.theme.Icons
import io.github.gouvinb.seagulls.feature.bookmarks.R as bookmarksR
import io.github.gouvinb.seagulls.feature.home.R as homeR
import io.github.gouvinb.seagulls.feature.search.R as searchR
import io.github.gouvinb.seagulls.feature.stand.R as standR

sealed class Screen(
    val route: String,
    val icon: ImageVector,
    @StringRes val titleRes: Int,
) {
    data object Home : Screen("/", Icons.Home, homeR.string.home_screen_title)
    data object Search : Screen("/search", Icons.Search, bookmarksR.string.bookmarks_screen_title)
    data object Bookmarks : Screen("/bookmarks", Icons.Bookmarks, searchR.string.search_screen_title)
    data object Stand : Screen("/stand", Icons.Category, standR.string.stand_screen_title)

    companion object {
        val items = listOf(
            Home,
            Search,
            Bookmarks,
            Stand,
        )
    }
}
