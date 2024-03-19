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
package io.github.gouvinb.seagulls.lib.core.domain.mapper

import io.github.gouvinb.seagulls.lib.core.data.local.model.TextInputLocal
import io.github.gouvinb.seagulls.lib.core.data.remote.model.TextInputRemote
import io.github.gouvinb.seagulls.lib.core.domain.model.TextInputDomain

object TextInputDomainMapper {
    fun mapFromDataLocal(item: TextInputLocal) = item
        .takeIf {
            it.title?.isNotBlank() == true &&
                it.description?.isNotBlank() == true &&
                it.name?.isNotBlank() == true &&
                it.link?.isNotBlank() == true
        }
        ?.let {
            TextInputDomain(
                title = it.title!!,
                description = it.description!!,
                name = it.name!!,
                link = it.link!!,
            )
        }

    fun mapToDataLocal(item: TextInputDomain) = TextInputLocal(
        title = item.title,
        description = item.description,
        name = item.name,
        link = item.link,
    )

    fun mapToDataRemote(item: TextInputDomain) = TextInputRemote(
        title = item.title,
        description = item.description,
        name = item.name,
        link = item.link,
    )
}
