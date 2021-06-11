package tech.eduardnow.personapi.infrastructure.controllers

import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import tech.eduardnow.personapi.application.update.PersonUpdate
import tech.eduardnow.personapi.application.update.PersonUpdateRequest

@RestController
@RequestMapping("/v1/persons")
class PersonPutController(private val service: PersonUpdate) {

    @PutMapping("/{code}")
    fun handle(@PathVariable code: String, @RequestBody request: HttpPersonUpdateRequest): ResponseEntity<Void> {
        service.handle(
            PersonUpdateRequest(code, request.firstname, request.lastname)
        )

        return ResponseEntity
            .noContent()
            .header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
            .build()
    }

}

data class HttpPersonUpdateRequest(val firstname: String, val lastname: String)