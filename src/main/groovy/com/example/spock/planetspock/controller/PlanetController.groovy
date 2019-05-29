package com.example.spock.planetspock.controller

import com.example.spock.planetspock.model.Planet
import com.example.spock.planetspock.serviece.PlanetService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import javax.servlet.http.HttpServletResponse

@RestController
class PlanetController {
    private final PlanetService planetService
    PlanetController(PlanetService pService) {
        this.planetService = pService
    }
    @RequestMapping(
            value = "/planets/{planetName}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public Planet retrieve(@PathVariable("planetName") String name) {
        return this.planetService.findOneByName(name)
    }
}
