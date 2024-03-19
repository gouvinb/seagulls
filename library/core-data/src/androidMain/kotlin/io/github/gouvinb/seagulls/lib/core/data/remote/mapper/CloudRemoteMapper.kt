package io.github.gouvinb.seagulls.lib.core.data.remote.mapper

import io.github.gouvinb.seagulls.lib.core.data.local.model.CloudLocal
import io.github.gouvinb.seagulls.lib.core.data.remote.model.CloudRemote
import io.github.gouvinb.seagulls.lib.core.data.remote.model.ImageRemote

object CloudRemoteMapper {
    fun mapToRemote(cloudLocal: CloudLocal) = CloudRemote(
        domain = cloudLocal.domain,
        port = cloudLocal.port,
        path = cloudLocal.path,
        registerProcedure = cloudLocal.registerProcedure,
        protocol = cloudLocal.protocol,
    )
}
