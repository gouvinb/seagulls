package io.github.gouvinb.seagulls.lib.core.datastore.serializer

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.google.protobuf.InvalidProtocolBufferException
import io.github.gouvinb.seagulls.lib.core.datastore.model.proto.UserPreferencesProto
import java.io.InputStream
import java.io.OutputStream

/**
 * An [androidx.datastore.core.Serializer] for the [UserPreferencesProto] proto.
 */
class UserPreferencesSerializer : Serializer<UserPreferencesProto> {
    override val defaultValue: UserPreferencesProto = UserPreferencesProto.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): UserPreferencesProto =
        try {
            UserPreferencesProto.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }

    override suspend fun writeTo(t: UserPreferencesProto, output: OutputStream) {
        t.writeTo(output)
    }
}
