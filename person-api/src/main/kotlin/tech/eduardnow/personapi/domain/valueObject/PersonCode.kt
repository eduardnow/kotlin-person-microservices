package tech.eduardnow.personapi.domain.valueObject

import java.util.*

data class PersonCode(val value: String) {
    init {
        UUID.fromString(value)
    }

    companion object {
        fun nextIdentity(): PersonCode = PersonCode(UUID.randomUUID().toString())
    }

}