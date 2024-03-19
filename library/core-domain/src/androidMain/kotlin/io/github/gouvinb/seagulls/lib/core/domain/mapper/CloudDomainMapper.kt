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

import io.github.gouvinb.seagulls.lib.core.data.local.model.CloudLocal
import io.github.gouvinb.seagulls.lib.core.data.remote.model.CloudRemote
import io.github.gouvinb.seagulls.lib.core.domain.model.CloudDomain

object CloudDomainMapper {
    fun mapFromDataLocal(item: CloudLocal) = item
        .takeIf {
            it.domain?.isNotBlank() == true &&
                it.port?.isNotBlank() == true &&
                it.path?.isNotBlank() == true &&
                it.registerProcedure?.isNotBlank() == true &&
                it.protocol?.isNotBlank() == true
        }
        ?.let {
            CloudDomain(
                domain = it.domain!!,
                port = it.port!!,
                path = it.path!!,
                registerProcedure = it.registerProcedure!!,
                protocol = it.protocol!!,
            )
        }

    fun mapToDataLocal(item: CloudDomain) = CloudLocal(
        domain = item.domain,
        port = item.port,
        path = item.path,
        registerProcedure = item.registerProcedure,
        protocol = item.protocol,
    )

    fun mapToDataRemote(item: CloudDomain) = CloudRemote(
        domain = item.domain,
        port = item.port,
        path = item.path,
        registerProcedure = item.registerProcedure,
        protocol = item.protocol,
    )
}
