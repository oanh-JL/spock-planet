package com.example.spock.planetspock.model
import spock.lang.Specification
class PlanetSpec extends Specification{

    Planet planet = new Planet()

    def "expect return planet's name"() {
        when :
        planet.setName(name)
        then:
        planet.getName().equals(expected)

        where:
        name            | expected
        "mercury"       | "mercury"
        "ABC_113"       | "ABC_113"

    }

    def "throw an illegalArgument expect if invalid name given" () {
        when :
        planet.setName(null)

        then:
        def e = thrown(IllegalArgumentException)
        e.message == "Planet name given was invalid"
    }

}
