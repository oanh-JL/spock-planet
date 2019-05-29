package com.example.spock.planetspock.repository

import com.example.spock.planetspock.model.Planet

 public interface PlanetRepository {
    Planet findOneByName( String name)

    void add( Planet planet)
}
