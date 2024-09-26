package edu.dereklopez.dam2024.feature.superheroes.domain

import edu.dereklopez.dam2024.feature.superheroes.data.SuperheroDataRepository
import edu.dereklopez.dam2024.feature.superheroes.data.remote.SuperheroMockRemoteDataSource
import edu.dereklopez.dam2024.feature.superheroes.data.remote.SuperheroRetrofitRemoteDataSource

class GetSuperheroUseCase(private val superheroRepository: SuperheroRepository) {
    suspend fun invoke(id: String): Superhero? {
        return superheroRepository.getSuperhero(id)
    }

}