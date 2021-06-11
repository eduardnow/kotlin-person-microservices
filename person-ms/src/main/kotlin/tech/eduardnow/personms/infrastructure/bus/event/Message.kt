package tech.eduardnow.personms.infrastructure.bus.event

import kotlinx.serialization.Serializable

@Serializable
data class Message(val id: String, val name: String, val occurredOn: String, val payload: String)