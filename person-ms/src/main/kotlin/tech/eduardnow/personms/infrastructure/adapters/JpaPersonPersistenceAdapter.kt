package tech.eduardnow.personms.infrastructure.adapters

import org.springframework.stereotype.Component
import tech.eduardnow.personms.domain.model.Person
import tech.eduardnow.personms.domain.spi.PersonPersistencePort
import tech.eduardnow.personms.domain.valueObject.PersonCode
import tech.eduardnow.personms.domain.valueObject.PersonFirstName
import tech.eduardnow.personms.domain.valueObject.PersonId
import tech.eduardnow.personms.domain.valueObject.PersonLastName
import tech.eduardnow.personms.infrastructure.persistence.PersonEntity
import tech.eduardnow.personms.infrastructure.persistence.PersonRepository

@Component
class JpaPersonPersistenceAdapter(private val repository: PersonRepository) : PersonPersistencePort {

    override fun save(person: Person) {

        val personEntity = PersonEntity(
            code = person.code.value,
            firstname = person.firstname.value,
            lastname = person.lastname.value
        )

        persist(personEntity)

    }

    override fun findByCode(code: String): Person? {

        val personEntity: PersonEntity = repository.findByCode(code)!!

        return Person(
            id = PersonId(personEntity.id!!),
            code = PersonCode(code),
            firstname = PersonFirstName(personEntity.firstname),
            lastname = PersonLastName(personEntity.lastname)
        )

    }

    override fun update(id: Int, person: Person) {

        val personEntity = PersonEntity(
            id = id,
            code = person.code.value,
            firstname = person.firstname.value,
            lastname = person.lastname.value
        )

        persist(personEntity)
    }

    private fun persist(personEntity: PersonEntity) {
        repository.save(personEntity)
    }

}