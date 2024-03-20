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

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.twotone.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.zIndex
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import io.github.gouvinb.seagulls.SeagullsAppState
import io.github.gouvinb.seagulls.lib.core.data.util.NetworkMonitor
import io.github.gouvinb.seagulls.lib.ui.theme.Icons
import io.github.gouvinb.seagulls.navigation.SeagullsNavHost
import io.github.gouvinb.seagulls.navigation.TopLevelDestination
import io.github.gouvinb.seagulls.rememberSeagullsAppState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SeagullsScreen(
    windowSizeClass: WindowSizeClass,
    networkMonitor: NetworkMonitor,
    appState: SeagullsAppState = rememberSeagullsAppState(
        networkMonitor = networkMonitor,
        windowSizeClass = windowSizeClass,
    ),
) {
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        containerColor = Color.Transparent,
        topBar = {
            val destination = appState.currentTopLevelDestination
            if (destination != null) {
                TopAppBar(
                    modifier = Modifier.zIndex(-1F),
                    title = { stringResource(id = destination.titleRes) },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(),
                    actions = {
                        IconButton(onClick = { appState.setShowSettingsDialog(true) }) {
                            Icon(
                                imageVector = Icons.Settings,
                                contentDescription = "stringResource(id = settingsR.string.top_app_bar_action_icon_description)",
                                tint = MaterialTheme.colorScheme.onSurface,
                            )
                        }
                    },
                )
            }
        },
        bottomBar = {
            SeagullsBottomBar(
                destinations = appState.topLevelDestinations,
                onNavigateToDestination = appState::navigateToTopLevelDestination,
                currentDestination = appState.currentDestination,
            )
        },
    ) { innerPadding ->
        val isOffline by appState.isOffline.collectAsStateWithLifecycle()

        val notConnected = "stringResource(R.string.not_connected)"
        LaunchedEffect(isOffline) {
            if (isOffline) {
                snackbarHostState.showSnackbar(
                    message = notConnected,
                    duration = SnackbarDuration.Indefinite,
                )
            }
        }

        if (appState.shouldShowSettingsDialog) {
            TODO("Make `SettingsDialog`")
            // SettingsDialog(onDismiss = { appState.setShowSettingsDialog(false) })
        }

        Row(
            Modifier
                .fillMaxSize()
                .windowInsetsPadding(
                    WindowInsets.safeDrawing.only(
                        WindowInsetsSides.Horizontal,
                    ),
                ),
        ) {
            if (appState.shouldShowNavRail) {
                SeagullsNavRail(
                    destinations = appState.topLevelDestinations,
                    onNavigateToDestination = appState::navigateToTopLevelDestination,
                    currentDestination = appState.currentDestination,
                    modifier = Modifier.safeDrawingPadding(),
                )
            }

            SeagullsNavHost(
                navController = appState.navController,
                onBackClick = appState::onBackClick,

                modifier = Modifier
                    .padding(innerPadding)
                    .consumeWindowInsets(innerPadding),
            )
        }
    }
}

@Composable
private fun SeagullsBottomBar(
    destinations: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?,
) {
    NavigationBar {
        destinations.forEach { destination ->
            val selected = currentDestination.isTopLevelDestinationInHierarchy(destination)
            NavigationBarItem(
                selected = selected,
                onClick = { onNavigateToDestination(destination) },
                icon = {
                    Icon(
                        imageVector = when (selected) {
                            true -> destination.selectedIcon
                            else -> destination.unselectedIcon
                        },
                        contentDescription = null,
                    )
                },
                label = { Text(stringResource(destination.titleRes)) },
            )
        }
    }
}

@Composable
private fun SeagullsNavRail(
    destinations: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier,
) {
    NavigationRail(modifier = modifier) {
        destinations.forEach { destination ->
            val selected = currentDestination.isTopLevelDestinationInHierarchy(destination)
            NavigationRailItem(
                selected = selected,
                onClick = { onNavigateToDestination(destination) },
                icon = {
                    Icon(
                        imageVector = when {
                            selected -> destination.selectedIcon
                            else -> destination.unselectedIcon
                        },
                        contentDescription = null,
                    )
                },
                label = { Text(stringResource(destination.titleRes)) },
            )
        }
    }
}

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TopLevelDestination) =
    this?.hierarchy?.any { it.route?.contains(destination.route, true) ?: false } ?: false
