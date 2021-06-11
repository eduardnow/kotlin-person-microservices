package tech.eduardnow.personapi

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType
import tech.eduardnow.personapi.domain.annotation.Service

@Configuration
@EnableAutoConfiguration
@ComponentScan(
    includeFilters = [ComponentScan.Filter(type = FilterType.ANNOTATION, classes = arrayOf(Service::class))]
)
class PersonApiApplication

fun main(args: Array<String>) {
    runApplication<PersonApiApplication>(*args)
}
