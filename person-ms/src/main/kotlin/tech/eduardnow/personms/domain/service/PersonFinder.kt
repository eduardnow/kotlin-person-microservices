package tech.eduardnow.personms.domain.service

import tech.eduardnow.personms.domain.annotation.Service
import tech.eduardnow.personms.domain.exceptions.PersonNotFound
import tech.eduardnow.personms.domain.model.Person
import tech.eduardnow.personms.domain.spi.PersonPersistencePort
import tech.eduardnow.personms.domain.valueObject.PersonCode

@Service
class PersonFinder(private val repository: PersonPersistencePort) {

    fun findByCode(code: PersonCode): Person {
        try {
            return repository.findByCode(code.value)!!
        } catch (e: NullPointerException) {
            throw PersonNotFound("Person with code ${code.value} not found")
        }
    }

}