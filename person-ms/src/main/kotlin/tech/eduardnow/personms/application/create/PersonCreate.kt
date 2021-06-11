package tech.eduardnow.personms.application.create

import tech.eduardnow.personms.domain.annotation.Service
import tech.eduardnow.personms.domain.bus.event.EventBus
import tech.eduardnow.personms.domain.model.Person
import tech.eduardnow.personms.domain.spi.PersonPersistencePort
import tech.eduardnow.personms.domain.valueObject.PersonFirstName
import tech.eduardnow.personms.domain.valueObject.PersonCode
import tech.eduardnow.personms.domain.valueObject.PersonLastName

@Service
class PersonCreate(private val repository: PersonPersistencePort, private val eventBus: EventBus) {

    fun handle(request: PersonCreateRequest): String {

        val code: PersonCode = PersonCode.nextIdentity()

        val person = Person.create(
            code,
            PersonFirstName(request.firstname),
            PersonLastName(request.lastname)
        )

        repository.save(person)

        eventBus.publish(person.pullDomainEvents())

        return code.value
    }
}