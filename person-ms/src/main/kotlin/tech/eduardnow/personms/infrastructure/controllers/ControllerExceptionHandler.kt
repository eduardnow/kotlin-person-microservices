package tech.eduardnow.personms.infrastructure.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestControllerAdvice
import tech.eduardnow.personms.domain.exceptions.PersonNotFound


@RestControllerAdvice
class ControllerExceptionsHandler  {

    @ResponseBody
    @ExceptionHandler(PersonNotFound::class)
    fun handlePersonNotFoundException(exception: PersonNotFound): ResponseEntity<ErrorResponse> {
        return ResponseEntity(
            ErrorResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.reasonPhrase, exception.message.toString()),
            HttpStatus.NOT_FOUND,
        )
    }

}
