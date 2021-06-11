package tech.eduardnow.personms.domain.bus.event

class PersonCreatedDomainEvent(
    private val aggregateId: String,
    val firstname: String,
    val lastname: String
) : DomainEvent() {

    override fun name(): String = "person.created"

    override fun payload(): String =
        """{"code": "$aggregateId", "firstname": "$firstname", "lastname": "$lastname"}"""

}