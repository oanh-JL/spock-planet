package com.example.spock.planetspock.serviece

import com.example.spock.planetspock.repository.PlanetRepository
import spock.lang.Specification

class PlanetServiceSpec extends Specification{
    def planetRepoMock = Mock(PlanetRepository)
    def planetService = new PlanetService(planetRepoMock)

    def 'use repository to fetch planet by name'() {
        when :
        planetService.findOneByName("Earth")

        then :
        1 * planetRepoMock.findOneByName("Earth")
    }
}
