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
