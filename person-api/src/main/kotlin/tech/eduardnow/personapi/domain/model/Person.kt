package tech.eduardnow.personapi.domain.model

import tech.eduardnow.personapi.domain.valueObject.PersonCode
import tech.eduardnow.personapi.domain.valueObject.PersonFirstName
import tech.eduardnow.personapi.domain.valueObject.PersonId
import tech.eduardnow.personapi.domain.valueObject.PersonLastName

class Person(
    val code: PersonCode,
    val firstname: PersonFirstName,
    val lastname: PersonLastName,
    val id: PersonId? = null
)
