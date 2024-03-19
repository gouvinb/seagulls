package io.github.gouvinb.seagulls.lib.core.data.local.mapper

import io.github.gouvinb.seagulls.lib.core.data.local.model.CloudLocal
import io.github.gouvinb.seagulls.lib.core.data.remote.model.CloudRemote

object CloudLocalMapper {
    fun mapToLocal(cloudRemote: CloudRemote) = CloudLocal(
        domain = cloudRemote.domain,
        port = cloudRemote.port,
        path = cloudRemote.path,
        registerProcedure = cloudRemote.registerProcedure,
        protocol = cloudRemote.protocol,
    )
}
