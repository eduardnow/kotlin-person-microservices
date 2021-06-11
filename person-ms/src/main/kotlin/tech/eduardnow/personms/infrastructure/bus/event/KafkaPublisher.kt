package tech.eduardnow.personms.infrastructure.bus.event

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import mu.KotlinLogging
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.lang.Nullable
import org.springframework.stereotype.Service
import org.springframework.util.concurrent.ListenableFuture
import org.springframework.util.concurrent.ListenableFutureCallback
import tech.eduardnow.personms.domain.bus.event.DomainEvent
import tech.eduardnow.personms.infrastructure.configuration.KafkaTopicConfig

private val logger = KotlinLogging.logger {}

@Service
class KafkaPublisher(
    private val kafkaTemplate: KafkaTemplate<String, String>,
    kafkaTopicConfig: KafkaTopicConfig
) {

    private val topicName: String? = kafkaTopicConfig.personTopic

    fun send(event: DomainEvent) {

        val message = Json.encodeToString(
            Message(event.id, event.name(), event.occurredOn, event.payload())
        )

        val future: ListenableFuture<SendResult<String, String>> =

            kafkaTemplate.send(topicName!!, message)

        future.addCallback(
            object : ListenableFutureCallback<SendResult<String, String>> {
                override fun onSuccess(@Nullable result: SendResult<String, String>?) {

                    logger.info {
                        "Sent message=[$message] with offset=[" + result!!.recordMetadata.offset()
                            .toString() + "]"
                    }

                }

                override fun onFailure(ex: Throwable) {
                    logger.info { "Unable to send message=[$message] due to : " + ex.message }
                }
            })

    }

}