package com.example.spock.planetspock.business

import com.example.spock.planetspock.model.Planet
import com.example.spock.planetspock.repository.PlanetRepository
import org.springframework.stereotype.Repository


@Repository
public class PlanetBusiness implements PlanetRepository {
    private Map<String, Planet> planets
    public PlanetBusiness() {
        this.planets = new  HashMap<>()
    }
    @Override
    public Planet findOneByName( String name) {
        return this.planets.get(name)
    }
    @Override
    public void add(Planet planet) {
        this.planets.put(planet.getName(),planet)
    }


}
