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
package io.github.gouvinb.seagulls.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.outlined.Bookmarks
import androidx.compose.material.icons.outlined.Category
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.twotone.Bookmarks
import androidx.compose.material.icons.twotone.Category
import androidx.compose.material.icons.twotone.Home
import androidx.compose.material.icons.twotone.Search
import androidx.compose.ui.graphics.vector.ImageVector
import io.github.gouvinb.seagulls.feature.bookmarks.R as bookmarksR
import io.github.gouvinb.seagulls.feature.bookmarks.navigation.BOOKMARKS_NAVIGATION_ROUTE
import io.github.gouvinb.seagulls.feature.home.R as homeR
import io.github.gouvinb.seagulls.feature.home.navigation.HOME_NAVIGATION_ROUTE
import io.github.gouvinb.seagulls.feature.search.R as searchR
import io.github.gouvinb.seagulls.feature.search.navigation.SEARCH_NAVIGATION_ROUTE
import io.github.gouvinb.seagulls.feature.stand.R as standR
import io.github.gouvinb.seagulls.feature.stand.navigation.STAND_NAVIGATION_ROUTE
import io.github.gouvinb.seagulls.lib.ui.theme.IconsSelected
import io.github.gouvinb.seagulls.lib.ui.theme.IconsUnselected

sealed class TopLevelDestination(
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    @StringRes val titleRes: Int,
) {
    data object Bookmarks : TopLevelDestination(
        route = BOOKMARKS_NAVIGATION_ROUTE,
        selectedIcon = IconsSelected.Bookmarks,
        unselectedIcon = IconsUnselected.Bookmarks,
        titleRes = bookmarksR.string.bookmarks_screen_title,
    )

    data object Home : TopLevelDestination(
        route = HOME_NAVIGATION_ROUTE,
        selectedIcon = IconsSelected.Home,
        unselectedIcon = IconsUnselected.Home,
        titleRes = homeR.string.home_screen_title,
    )

    data object Search : TopLevelDestination(
        route = SEARCH_NAVIGATION_ROUTE,
        selectedIcon = IconsSelected.Search,
        unselectedIcon = IconsUnselected.Search,
        titleRes = searchR.string.search_screen_title,
    )

    data object Stand : TopLevelDestination(
        route = STAND_NAVIGATION_ROUTE,
        selectedIcon = IconsSelected.Category,
        unselectedIcon = IconsUnselected.Category,
        titleRes = standR.string.stand_screen_title,
    )

    companion object {
        val items = listOf(
            Home,
            Search,
            Bookmarks,
            Stand,
        )
    }
}
