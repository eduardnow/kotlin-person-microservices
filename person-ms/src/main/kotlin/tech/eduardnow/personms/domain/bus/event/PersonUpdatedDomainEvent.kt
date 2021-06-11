package tech.eduardnow.personms.domain.bus.event

class PersonUpdatedDomainEvent(
    private val aggregateId: String,
    val firstname: String,
    val lastname: String
) : DomainEvent() {

    override fun name(): String = "person.updated"

    override fun payload(): String =
        """{"code": "$aggregateId", "firstname": "$firstname", "lastname": "$lastname"}"""

}