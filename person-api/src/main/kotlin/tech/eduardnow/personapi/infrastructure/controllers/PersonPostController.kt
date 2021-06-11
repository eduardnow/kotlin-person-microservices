package tech.eduardnow.personapi.infrastructure.controllers

import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
import tech.eduardnow.personapi.application.create.PersonCreate
import tech.eduardnow.personapi.application.create.PersonCreateRequest
import tech.eduardnow.personapi.domain.model.Person

@RestController
@RequestMapping("/v1/persons")
class PersonPostController(private val service: PersonCreate) {

    @PostMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun handle(@RequestBody request: HttpPersonCreateRequest): ResponseEntity<Person> {

        val identity: String = service.handle(
            PersonCreateRequest(request.firstname, request.lastname)
        )

        return ResponseEntity
            .created(UriComponentsBuilder.fromPath("{code}").buildAndExpand(identity).toUri())
            .contentType(MediaType.APPLICATION_JSON)
            .build()
    }

}

data class HttpPersonCreateRequest(val firstname: String, val lastname: String)