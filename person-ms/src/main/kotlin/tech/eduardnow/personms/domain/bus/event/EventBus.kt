package tech.eduardnow.personms.domain.bus.event

interface EventBus {
    fun publish(events: List<DomainEvent>)
}