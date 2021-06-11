package tech.eduardnow.personapi.domain.spi

import tech.eduardnow.personapi.domain.model.Person

interface PersonMsUpdatePort {
    fun update(person: Person)
}