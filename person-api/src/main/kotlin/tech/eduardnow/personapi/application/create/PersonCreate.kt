package tech.eduardnow.personapi.application.create

import tech.eduardnow.personapi.domain.annotation.Service
import tech.eduardnow.personapi.domain.model.Person
import tech.eduardnow.personapi.domain.spi.PersonMsCreatePort
import tech.eduardnow.personapi.domain.valueObject.PersonCode
import tech.eduardnow.personapi.domain.valueObject.PersonFirstName
import tech.eduardnow.personapi.domain.valueObject.PersonLastName

@Service
class PersonCreate(private val personMsCreatePort: PersonMsCreatePort) {

    fun handle(request: PersonCreateRequest): String {

        val code: PersonCode = PersonCode.nextIdentity()

        val person = Person(
            code,
            PersonFirstName(request.firstname),
            PersonLastName(request.lastname)
        )

        return personMsCreatePort.create(person)
    }
}