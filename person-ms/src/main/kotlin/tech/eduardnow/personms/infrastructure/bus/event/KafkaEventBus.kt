package tech.eduardnow.personms.infrastructure.bus.event

import org.springframework.stereotype.Component
import tech.eduardnow.personms.domain.bus.event.DomainEvent
import tech.eduardnow.personms.domain.bus.event.EventBus

@Component
class KafkaEventBus(private val publisher: KafkaPublisher) : EventBus {

    override fun publish(events: List<DomainEvent>) {
        events.forEach { publish(it) }
    }

    private fun publish(domainEvent: DomainEvent) {
        publisher.send(domainEvent)
    }

}