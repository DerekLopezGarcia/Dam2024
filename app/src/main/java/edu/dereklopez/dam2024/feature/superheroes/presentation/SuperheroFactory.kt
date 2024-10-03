package edu.dereklopez.dam2024.feature.superheroes.presentation

import android.content.Context
import edu.dereklopez.dam2024.feature.superheroes.data.SuperheroDataRepository
import edu.dereklopez.dam2024.feature.superheroes.data.local.SuperheroXmlLocalDataSource
import edu.dereklopez.dam2024.feature.superheroes.data.remote.SuperheroMockRemoteDataSource
import edu.dereklopez.dam2024.feature.superheroes.domain.GetSuperheroUseCase
import edu.dereklopez.dam2024.feature.superheroes.domain.GetSuperheroesUseCase

class SuperheroFactory (private val context: Context){
    private val superheroMockRemoteDataSource = SuperheroMockRemoteDataSource()
    private val superherolocal = SuperheroXmlLocalDataSource(context)
    private val superheroDataRepository = SuperheroDataRepository(superheroMockRemoteDataSource, superherolocal)
    val getSuperheroesUseCase = GetSuperheroesUseCase(superheroDataRepository)
    val getSuperheroUseCase = GetSuperheroUseCase(superheroDataRepository)

    fun buildViewModel(): SuperheroViewModel {
        return SuperheroViewModel(getSuperheroesUseCase, getSuperheroUseCase)
    }
}