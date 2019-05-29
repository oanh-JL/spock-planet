package com.example.spock.planetspock.business

import com.example.spock.planetspock.model.Planet
import com.example.spock.planetspock.repository.PlanetRepository
import spock.lang.Specification

class PlanetBusinessSpec extends Specification {
    PlanetRepository planetRepository = new PlanetBusiness()

    def " return instant Planet name " () {
        given :
        def earth = Stub(Planet)
        earth.getName() >>"Earth"
        planetRepository.add(earth)

        when :
        def planet = this.planetRepository.findOneByName("Earth")

        then:
        planet.getName() == "Earth"
    }
    def " description for method"() {
        given: "an empty  planet"
        // ...

        when: "the planet was declare name"
        // ...

        then: "the planet's name is same block 'when' declared"
        // ...
    }
}
