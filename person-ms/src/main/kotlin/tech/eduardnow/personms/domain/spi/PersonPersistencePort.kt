package tech.eduardnow.personms.domain.spi

import tech.eduardnow.personms.domain.model.Person

interface PersonPersistencePort {

    fun save(person: Person)

    fun findByCode(code: String): Person?

    fun update(id: Int, person: Person)

}