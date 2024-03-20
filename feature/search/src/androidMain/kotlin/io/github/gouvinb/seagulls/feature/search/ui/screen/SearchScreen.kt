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
package io.github.gouvinb.seagulls.feature.search.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.github.gouvinb.seagulls.feature.search.BuildConfig
import io.github.gouvinb.seagulls.feature.search.navigation.SEARCH_NAVIGATION_ROUTE
import io.github.gouvinb.seagulls.lib.ui.component.Todo
import io.github.gouvinb.seagulls.lib.ui.theme.Dimension

@Composable
fun SearchScreen(route: String) {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Todo(
            text = when {
                BuildConfig.DEBUG -> "SearchScreen route: $route"
                else -> null
            },
            modifier = Modifier
                .padding(Dimension.normalSpacing)
                .wrapContentHeight(),
        )
    }
}

// add apiLevel = 33 for avoid crash on preview
// See: https://issuetracker.google.com/issues/324732800
@Preview(apiLevel = 33, showBackground = true)
@Composable
fun SearchScreenPreview() {
    SearchScreen(SEARCH_NAVIGATION_ROUTE)
}
