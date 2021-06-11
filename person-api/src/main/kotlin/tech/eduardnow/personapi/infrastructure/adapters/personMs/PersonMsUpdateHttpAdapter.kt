package tech.eduardnow.personapi.infrastructure.adapters.personMs

import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClientResponseException
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder
import tech.eduardnow.personapi.domain.exception.PersonMsException
import tech.eduardnow.personapi.domain.exception.PersonNotFound
import tech.eduardnow.personapi.domain.model.Person
import tech.eduardnow.personapi.domain.spi.PersonMsUpdatePort
import tech.eduardnow.personapi.infrastructure.configuration.PersonMsConfig

private val logger = KotlinLogging.logger {}

@Component
class PersonMsUpdateHttpAdapter(
    private val restTemplate: RestTemplate,
    private val personMsConfig: PersonMsConfig
) : PersonMsUpdatePort {

    override fun update(person: Person) = try {

        val code = person.code.value

        val endpoint = UriComponentsBuilder
            .fromHttpUrl(personMsConfig.url)
            .path("/persons/$code")
            .build()
            .toUri()

        restTemplate
            .put(
                endpoint,
                PersonMsRequest(person.firstname.value, person.lastname.value)
            )

        logger.info { "Person with the code $code was updated" }

    } catch (e: RestClientResponseException) {

        logger.error { " Status=[${e.statusText}], message=[${e.message}], trace=[${e.stackTraceToString()}]" }

        if (e.rawStatusCode == HttpStatus.NOT_FOUND.value())
            throw PersonNotFound("Person with the code ${person.code.value} not found")
        else throw PersonMsException(
            "PersonMs service unavailable"
        )
    }


}