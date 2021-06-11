package tech.eduardnow.personapi.application.update

import tech.eduardnow.personapi.domain.annotation.Service
import tech.eduardnow.personapi.domain.model.Person
import tech.eduardnow.personapi.domain.spi.PersonMsUpdatePort
import tech.eduardnow.personapi.domain.valueObject.PersonCode
import tech.eduardnow.personapi.domain.valueObject.PersonFirstName
import tech.eduardnow.personapi.domain.valueObject.PersonLastName

@Service
class PersonUpdate(private val personMsUpdatePort: PersonMsUpdatePort) {

    fun handle(request: PersonUpdateRequest) {

        personMsUpdatePort.update(
            Person(
                PersonCode(request.code),
                PersonFirstName(request.firstname),
                PersonLastName(request.lastname)
            )
        )

    }

}