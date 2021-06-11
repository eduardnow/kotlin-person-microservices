package tech.eduardnow.personapi.infrastructure.controllers

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import tech.eduardnow.personapi.PersonApiApplication
import java.util.*

@ExtendWith(SpringExtension::class)
@SpringBootTest(classes = [PersonApiApplication::class])
@AutoConfigureMockMvc
class PersonPutControllerShould(@Autowired private val mockMvc: MockMvc) {

    @Test
    fun `not update a person if not exists`() {

        val code = UUID.randomUUID()
        val firstname = "Joe"
        val lastname = "Doe"

        val payload = """{"firstname": "$firstname", "lastname": "$lastname"}"""

        // Execute the PUT request
        mockMvc.perform(
            MockMvcRequestBuilders.put("/v1/person/${code}")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload)
        )
            // Validate the response code and content type
            .andExpect(MockMvcResultMatchers.status().isNotFound)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
    }
}