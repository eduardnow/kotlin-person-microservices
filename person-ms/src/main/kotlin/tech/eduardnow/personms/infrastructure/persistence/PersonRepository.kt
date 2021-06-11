package tech.eduardnow.personms.infrastructure.persistence

import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository : JpaRepository<PersonEntity, Int> {

    fun findByCode(code: String): PersonEntity?

}