package com.example.spock.planetspock.serviece

import com.example.spock.planetspock.model.Planet
import com.example.spock.planetspock.repository.PlanetRepository
import org.springframework.stereotype.Service

@Service
class PlanetService {
    private final PlanetRepository repository
    public PlanetService(PlanetRepository planetRepository) {
        this.repository = planetRepository
    }
    public Planet findOneByName(String pName) {
        return this.repository.findOneByName(pName)
    }
}
