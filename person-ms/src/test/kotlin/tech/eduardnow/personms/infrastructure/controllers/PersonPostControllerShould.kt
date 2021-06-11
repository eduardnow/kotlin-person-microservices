package tech.eduardnow.personms.infrastructure.controllers

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
import tech.eduardnow.personms.PersonMsApplication

@ExtendWith(SpringExtension::class)
@SpringBootTest(classes = [PersonMsApplication::class])
@AutoConfigureMockMvc
class PersonPostControllerShould(@Autowired private val mockMvc: MockMvc) {

    @Test
    fun `store a valid person`() {

        val firstname = "Joe"
        val lastname = "Doe"

        val payload = """{"firstname": "$firstname", "lastname": "$lastname"}"""

        // Execute the POST request
        mockMvc.perform(
            MockMvcRequestBuilders.post("/v1/person")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload)
        )
            // Validate the response code and content type
            .andExpect(MockMvcResultMatchers.status().isCreated)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.header().exists("location"))

    }

    @Test
    fun `not store an invalid person`() {

        val firstname = "Joe"

        val payload = """{"firstname": "$firstname"}"""

        // Execute the POST request
        mockMvc.perform(
            MockMvcRequestBuilders.post("/v1/person")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload)
        )
            // Validate the response code and content type
            .andExpect(MockMvcResultMatchers.status().isBadRequest)

    }

}