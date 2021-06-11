package tech.eduardnow.personms.domain.model

import tech.eduardnow.personms.domain.AggregateRoot
import tech.eduardnow.personms.domain.bus.event.PersonCreatedDomainEvent
import tech.eduardnow.personms.domain.bus.event.PersonUpdatedDomainEvent
import tech.eduardnow.personms.domain.valueObject.*

class Person(
    val code: PersonCode,
    val firstname: PersonFirstName,
    val lastname: PersonLastName,
    val id: PersonId? = null
) : AggregateRoot() {

    companion object {
        fun create(code: PersonCode, firstname: PersonFirstName, lastname: PersonLastName): Person {
            val person = Person(code, firstname, lastname)

            person.record(PersonCreatedDomainEvent(code.value, firstname.value, lastname.value))

            return person
        }

        fun update(code: PersonCode, firstname: PersonFirstName, lastname: PersonLastName): Person {
            val person = Person(code, firstname, lastname)

            person.record(PersonUpdatedDomainEvent(code.value, firstname.value, lastname.value))

            return person
        }
    }

}
