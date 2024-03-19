package io.github.gouvinb.seagulls.lib.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.twotone.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import io.github.gouvinb.seagulls.lib.ui.R
import io.github.gouvinb.seagulls.lib.ui.theme.Dimension
import io.github.gouvinb.seagulls.lib.ui.theme.Icons
import io.github.gouvinb.seagulls.lib.ui.theme.SeagullsTheme

@Composable
fun Todo(modifier: Modifier = Modifier, text: String? = null, contentDescription: String = stringResource(id = R.string.label_screen_wip)) {
    var textBase = stringResource(id = R.string.label_screen_wip)
    if (text?.isNotBlank() == true) {
        textBase = "$textBase\n\n$text"
    }

    Card(modifier) {
        Row(Modifier.padding(Dimension.normalSpacing)) {
            Icon(
                Icons.Warning,
                tint = MaterialTheme.colorScheme.primary,
                contentDescription = contentDescription,
                modifier = Modifier.padding(end = Dimension.normalSpacing)
            )
            Text(textBase)
        }
    }
}

// add apiLevel = 33 for avoid crash on preview
// See: https://issuetracker.google.com/issues/324732800
@Preview(apiLevel = 33, showBackground = true)
@Composable
fun TodoPreview() {
    SeagullsTheme {
        Todo(text = LoremIpsum(16).values.joinToString(" "))
    }
}
