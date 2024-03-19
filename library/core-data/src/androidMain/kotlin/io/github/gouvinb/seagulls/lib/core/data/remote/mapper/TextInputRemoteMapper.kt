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
package io.github.gouvinb.seagulls.lib.core.data.remote.mapper

import io.github.gouvinb.seagulls.lib.core.data.local.model.CloudLocal
import io.github.gouvinb.seagulls.lib.core.data.local.model.TextInputLocal
import io.github.gouvinb.seagulls.lib.core.data.remote.model.CloudRemote
import io.github.gouvinb.seagulls.lib.core.data.remote.model.ImageRemote
import io.github.gouvinb.seagulls.lib.core.data.remote.model.TextInputRemote

object TextInputRemoteMapper {
    fun mapToRemote(textInputLocal: TextInputLocal) = TextInputRemote(
        title = textInputLocal.title,
        description = textInputLocal.description,
        name = textInputLocal.name,
        link = textInputLocal.link,
    )
}
