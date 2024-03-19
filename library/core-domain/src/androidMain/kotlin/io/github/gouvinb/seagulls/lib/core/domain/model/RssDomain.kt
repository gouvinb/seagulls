package io.github.gouvinb.seagulls.lib.core.domain.model

data class RssDomain(
    val title: String,
    val description: String,
    val link: String,
    val language: String? = null,
    val copyright: String? = null,
    val managingEditor: String? = null,
    val webMaster: String? = null,
    val pubDate: String? = null,
    val lastBuildDate: String? = null,
    val generator: String? = null,
    val docs: String? = null,
    val cloud: CloudDomain? = null,
    val ttl: String? = null,
    val image: ImageDomain? = null,
    val rating: String? = null,
    val textInput: TextInputDomain? = null,
    val skipHours: String? = null,
    val skipDays: String? = null,
)
