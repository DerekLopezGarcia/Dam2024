package edu.dereklopez.dam2024.feature.superheroes.presentation

import androidx.lifecycle.ViewModel
import edu.dereklopez.dam2024.feature.superheroes.domain.GetSuperheroesUseCase
import edu.dereklopez.dam2024.feature.superheroes.domain.Superhero

class SuperheroViewModel(private val getSuperheroesUseCase: GetSuperheroesUseCase) : ViewModel() {
    fun viewCreated(): List<Superhero> {
        return getSuperheroesUseCase.invoke()
    }
    fun itemsSelected(id: String): Superhero? {
        return getSuperheroesUseCase.invoke().find { it.id == id }
    }

}