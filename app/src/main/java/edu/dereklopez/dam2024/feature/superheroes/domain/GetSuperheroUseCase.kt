package edu.dereklopez.dam2024.feature.superheroes.domain

import edu.dereklopez.dam2024.feature.superheroes.data.SuperheroDataRepository
import edu.dereklopez.dam2024.feature.superheroes.data.remote.SuperheroMockRemoteDataSource

class GetSuperheroUseCase(private val superheroRepository: SuperheroDataRepository) {
    fun invoke(id: String): Superhero? {
        return superheroRepository.getSuperhero(id)
    }

}