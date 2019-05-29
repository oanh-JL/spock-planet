package com.example.spock.planetspock.controller

import com.example.spock.planetspock.serviece.PlanetService
import spock.lang.Specification

class PlanetControllerSpec extends Specification {
    def planetServer = Mock(PlanetService)
    def planetController = new PlanetController(planetServer)

    def " should ask planetService about earth information"() {
        when:
        planetController.retrieve("earth")

        then:
        1 * planetServer.findOneByName("earth")
    }

}
