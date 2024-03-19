package io.github.gouvinb.seagulls.feature.stand.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import io.github.gouvinb.seagulls.feature.stand.BuildConfig
import io.github.gouvinb.seagulls.lib.ui.component.Todo
import io.github.gouvinb.seagulls.lib.ui.theme.Dimension

@Composable
fun StandScreen(navController: NavHostController) {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Todo(
            text = when {
                BuildConfig.DEBUG -> "StandScreen route: ${navController.currentDestination?.route}"
                else -> null
            },
            modifier = Modifier
                .padding(Dimension.normalSpacing)
                .wrapContentHeight()
        )
    }
}

// add apiLevel = 33 for avoid crash on preview
// See: https://issuetracker.google.com/issues/324732800
@Preview(apiLevel = 33, showBackground = true)
@Composable
fun StandScreenPreview() {
    StandScreen(NavHostController(LocalContext.current))
}
