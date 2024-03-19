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
