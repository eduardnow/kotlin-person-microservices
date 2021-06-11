package tech.eduardnow.personapi.infrastructure.controllers

import com.fasterxml.jackson.annotation.JsonFormat
import java.util.*

class ErrorResponse(
    val status: Int,
    val error: String,
    val message: String,
) {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy hh:mm:ss")
    val timestamp: Date = Date()
}