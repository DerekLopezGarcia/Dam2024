package edu.dereklopez.dam2024.feature.superheroes.presentation

import androidx.lifecycle.ViewModel
import edu.dereklopez.dam2024.feature.superheroes.domain.GetSuperheroUseCase
import edu.dereklopez.dam2024.feature.superheroes.domain.GetSuperheroesUseCase
import edu.dereklopez.dam2024.feature.superheroes.domain.Superhero

class SuperheroViewModel(
    private val getSuperheroesUseCase: GetSuperheroesUseCase,
    private val getSuperheroUseCase: GetSuperheroUseCase
) : ViewModel() {
    fun viewCreated() {
        getSuperheroesUseCase.invoke()
    }
    fun itemSelected(id: String): Superhero? {
        return getSuperheroUseCase.invoke(id)
    }
    }