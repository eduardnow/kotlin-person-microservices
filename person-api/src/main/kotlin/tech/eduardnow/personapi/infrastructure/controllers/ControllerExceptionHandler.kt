package tech.eduardnow.personapi.infrastructure.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestControllerAdvice
import tech.eduardnow.personapi.domain.exception.PersonMsException
import tech.eduardnow.personapi.domain.exception.PersonNotFound

@RestControllerAdvice
class ControllerExceptionsHandler {

    @ResponseBody
    @ExceptionHandler(PersonNotFound::class)
    fun handlePersonNotFoundException(exception: PersonNotFound): ResponseEntity<ErrorResponse> {
        return ResponseEntity(
            ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.reasonPhrase,
                exception.message.toString()
            ),
            HttpStatus.NOT_FOUND,
        )
    }

    @ResponseBody
    @ExceptionHandler(PersonMsException::class)
    fun handlePersonMsException(exception: PersonMsException): ResponseEntity<ErrorResponse> {
        return ResponseEntity(
            ErrorResponse(
                HttpStatus.SERVICE_UNAVAILABLE.value(),
                HttpStatus.SERVICE_UNAVAILABLE.reasonPhrase,
                exception.message.toString()
            ),
            HttpStatus.SERVICE_UNAVAILABLE,
        )
    }

}