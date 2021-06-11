package tech.eduardnow.personms

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType
import tech.eduardnow.personms.domain.annotation.Service

@Configuration
@EnableAutoConfiguration
@ComponentScan(
    includeFilters = [ComponentScan.Filter(type = FilterType.ANNOTATION, classes = arrayOf(Service::class))]
)
class PersonMsApplication

fun main(args: Array<String>) {
    runApplication<PersonMsApplication>(*args)
}
