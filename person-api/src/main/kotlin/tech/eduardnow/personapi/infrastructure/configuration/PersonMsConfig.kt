package tech.eduardnow.personapi.infrastructure.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties("app.person-ms")
class PersonMsConfig {

    lateinit var url: String

}