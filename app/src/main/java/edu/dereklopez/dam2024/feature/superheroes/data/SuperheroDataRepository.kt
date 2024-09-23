package edu.dereklopez.dam2024.feature.superheroes.data

import edu.dereklopez.dam2024.feature.superheroes.data.remote.SuperheroMockRemoteDataSource
import edu.dereklopez.dam2024.feature.superheroes.domain.Superhero
import edu.dereklopez.dam2024.feature.superheroes.domain.SuperheroRepository

class SuperheroDataRepository(private val mockRemoteDataSource: SuperheroMockRemoteDataSource) :
    SuperheroRepository {
    override fun getSuperheroes(): List<Superhero> {
        return mockRemoteDataSource.getSuperheroes()
    }
}