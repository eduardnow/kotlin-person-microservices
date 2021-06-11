package tech.eduardnow.personms.domain.bus.event

import tech.eduardnow.personms.domain.Utils
import java.time.LocalDateTime
import java.util.*

abstract class DomainEvent {

    val id: String = UUID.randomUUID().toString()
    val occurredOn: String = Utils.dateToString(LocalDateTime.now())

    abstract fun name(): String
    abstract fun payload(): String

}