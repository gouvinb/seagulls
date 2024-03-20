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

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import io.github.gouvinb.seagulls.feature.bookmarks.navigation.bookmarksScreen
import io.github.gouvinb.seagulls.feature.home.navigation.HOME_NAVIGATION_ROUTE
import io.github.gouvinb.seagulls.feature.home.navigation.homeScreen
import io.github.gouvinb.seagulls.feature.search.navigation.searchScreen
import io.github.gouvinb.seagulls.feature.stand.navigation.standScreen

@Composable
fun SeagullsNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    onBackClick: () -> Unit,
    startDestination: String = HOME_NAVIGATION_ROUTE,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        homeScreen()
        bookmarksScreen()
        searchScreen()
        standScreen()
    }
}
