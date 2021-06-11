package tech.eduardnow.personms.infrastructure.persistence

import javax.persistence.*
import javax.persistence.GenerationType.IDENTITY

@Entity
@Table(name = "persons")
data class PersonEntity(

    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Int? = null,

    @Column(nullable = false, unique = true)
    val code: String? = null,

    @Column(nullable = false)
    val firstname: String = "",

    @Column(nullable = false)
    val lastname: String = ""

)