package tech.eduardnow.personapi.domain.spi

import tech.eduardnow.personapi.domain.model.Person

interface PersonMsCreatePort {
    fun create(person: Person): String
}