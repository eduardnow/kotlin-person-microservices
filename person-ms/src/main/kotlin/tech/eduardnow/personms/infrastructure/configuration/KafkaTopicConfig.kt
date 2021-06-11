package tech.eduardnow.personms.infrastructure.configuration

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder


@Configuration
class KafkaTopicConfig {

    @Value("\${app.kafka.topic.person-topic}")
    val personTopic: String? = null

    @Bean
    fun topicPerson(): NewTopic? {
        return TopicBuilder.name(personTopic.toString()).build()
    }

}