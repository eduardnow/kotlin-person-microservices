package tech.eduardnow.personapi.infrastructure.adapters.personMs

import kotlinx.serialization.Serializable

@Serializable
data class PersonMsResponse(
    val status: String,
    val message: String,
    val timestamp: String,
    val error: String,
    val trace: String? = null
)