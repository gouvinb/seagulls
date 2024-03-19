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
