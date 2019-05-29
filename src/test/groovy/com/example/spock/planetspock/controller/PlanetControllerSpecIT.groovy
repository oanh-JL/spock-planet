package com.example.spock.planetspock.controller

import com.example.spock.planetspock.model.Planet
import com.example.spock.planetspock.repository.PlanetRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.http.MediaType.APPLICATION_JSON
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class PlanetControllerSpecIT extends  Specification{
    @Autowired
    private MockMvc mockMvc

    @Autowired
    private PlanetRepository repository

    def "should return planet detail by JSON" () {
        given :
        Planet earth = new Planet()
        earth.setName("Earth")
        repository.add(earth)

        when:
        def response = mockMvc.perform(
                get("/planets/Earth")
                        .contentType(APPLICATION_JSON)
        )
        then :
        response
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath('$.name', is('Earth')))

    }

}
