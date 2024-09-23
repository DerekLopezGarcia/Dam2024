package edu.dereklopez.dam2024.feature.superheroes.presentation

import edu.dereklopez.dam2024.feature.superheroes.data.SuperheroDataRepository
import edu.dereklopez.dam2024.feature.superheroes.data.remote.SuperheroMockRemoteDataSource
import edu.dereklopez.dam2024.feature.superheroes.domain.GetSuperheroesUseCase

class SuperheroFactory {
    fun buildViewModel(): SuperheroViewModel {
        return SuperheroViewModel(
            GetSuperheroesUseCase(
                SuperheroDataRepository(
                    SuperheroMockRemoteDataSource()
                )
            )
        )
    }

}