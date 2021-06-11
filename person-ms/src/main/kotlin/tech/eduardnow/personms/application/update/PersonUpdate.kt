package tech.eduardnow.personms.application.update

import tech.eduardnow.personms.domain.annotation.Service
import tech.eduardnow.personms.domain.bus.event.EventBus
import tech.eduardnow.personms.domain.model.Person
import tech.eduardnow.personms.domain.service.PersonFinder
import tech.eduardnow.personms.domain.spi.PersonPersistencePort
import tech.eduardnow.personms.domain.valueObject.PersonFirstName
import tech.eduardnow.personms.domain.valueObject.PersonCode
import tech.eduardnow.personms.domain.valueObject.PersonLastName

@Service
class PersonUpdate(private val repository: PersonPersistencePort, private val eventBus: EventBus) {

    private val finder = PersonFinder(repository)

    fun handle(request: PersonUpdateRequest) {

        val person: Person = finder.findByCode(PersonCode(request.code))

        val personUpdate = Person.update(
            person.code,
            PersonFirstName(request.firstname),
            PersonLastName(request.lastname)
        )

        repository.update(person.id!!.value, personUpdate)

        eventBus.publish(personUpdate.pullDomainEvents())

    }

}