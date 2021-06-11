package tech.eduardnow.personms.infrastructure.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthCheckGetController {

    @GetMapping("/health-check")
    fun handle(): HashMap<String, String> {
        return hashMapOf("status" to "ok")
    }

}