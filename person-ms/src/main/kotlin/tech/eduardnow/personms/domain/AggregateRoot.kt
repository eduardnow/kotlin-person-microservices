package tech.eduardnow.personms.domain

import tech.eduardnow.personms.domain.bus.event.DomainEvent

abstract class AggregateRoot {

    private var domainsEvents: MutableList<DomainEvent> = mutableListOf()

    fun pullDomainEvents(): List<DomainEvent> {
        val events: MutableList<DomainEvent> = domainsEvents.toMutableList()

        domainsEvents.clear()

        return events
    }

    fun record(domainEvent: DomainEvent) {
        domainsEvents.add(domainEvent)
    }

}
