package tech.eduardnow.personapi.infrastructure.adapters.personMs

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import mu.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClientResponseException
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder
import tech.eduardnow.personapi.domain.exception.PersonMsException
import tech.eduardnow.personapi.domain.model.Person
import tech.eduardnow.personapi.domain.spi.PersonMsCreatePort
import tech.eduardnow.personapi.infrastructure.configuration.PersonMsConfig
import java.net.URI

private val logger = KotlinLogging.logger {}

@Component
class PersonMsCreateHttpAdapter(
    private val restTemplate: RestTemplate,
    private val personMsConfig: PersonMsConfig
) : PersonMsCreatePort {

    override fun create(person: Person): String = try {

        val endpoint = UriComponentsBuilder
            .fromHttpUrl(personMsConfig.url)
            .path("/persons")
            .build()
            .toUri()

        val response: ResponseEntity<Void> = request(endpoint, person)

        val resourceLocation: String = response.headers.location.toString()

        logger.info { "Person with the code $resourceLocation was updated" }

        resourceLocation

    } catch (e: RestClientResponseException) {

        logger.error { " Status=[${e.statusText}], message=[${e.message}], trace=[${e.stackTraceToString()}]" }

        throw PersonMsException("PersonMs service unavailable")
    }

    @CircuitBreaker(name = "personMsService", fallbackMethod = "fallbackProcess")
    private fun request(endpoint: URI, person: Person): ResponseEntity<Void> {
        return restTemplate
            .postForEntity(
                endpoint,
                PersonMsRequest(person.firstname.value, person.lastname.value),
                Void::class.java
            )
    }

    fun fallbackProcess(id: Int, e: Throwable): ResponseEntity<Void> {
        logger.error { " Cause=[${e.cause}], message=[${e.message}], trace=[${e.stackTraceToString()}]" }

        throw PersonMsException("PersonMs service unavailable")
    }

}