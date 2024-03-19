package io.github.gouvinb.seagulls.lib.core.ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


sealed class RssUi(
    open val title: String,
    open val link: String,
    open val description: String,
) {
    @Parcelize
    data class RssBasicUi(
        override val title: String,
        override val link: String,
        override val description: String,
    ) : RssUi(
        title,
        link,
        description,
    ), Parcelable
}
