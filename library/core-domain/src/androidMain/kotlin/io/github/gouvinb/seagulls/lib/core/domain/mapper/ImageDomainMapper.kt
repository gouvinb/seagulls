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

import io.github.gouvinb.seagulls.lib.core.data.local.model.ImageLocal
import io.github.gouvinb.seagulls.lib.core.data.remote.model.ImageRemote
import io.github.gouvinb.seagulls.lib.core.domain.model.ImageDomain

object ImageDomainMapper {
    fun mapFromDataLocal(item: ImageLocal) = item
        .takeIf {
            it.url?.isNotBlank() == true &&
                it.title?.isNotBlank() == true &&
                it.link?.isNotBlank() == true
        }
        ?.let {
            ImageDomain(
                url = it.url!!,
                title = it.title!!,
                link = it.link!!,
                width = it.width,
                height = it.height,
            )
        }

    fun mapToDataLocal(item: ImageDomain) = ImageLocal(
        url = item.url,
        title = item.title,
        link = item.link,
        width = item.width,
        height = item.height,
    )

    fun mapToDataRemote(item: ImageDomain) = ImageRemote(
        url = item.url,
        title = item.title,
        link = item.link,
        width = item.width,
        height = item.height,
    )
}
