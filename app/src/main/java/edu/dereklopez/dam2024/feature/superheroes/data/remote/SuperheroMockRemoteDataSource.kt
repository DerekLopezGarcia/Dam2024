package edu.dereklopez.dam2024.feature.superheroes.data.remote

import edu.dereklopez.dam2024.feature.superheroes.domain.Superhero

class SuperheroMockRemoteDataSource {
    val localSuperheroes = listOf(
        Superhero("1", "Super1",),
        Superhero("2", "Super2",),
        Superhero("3", "Super3",)
    )

    fun getSuperheroes(): List<Superhero> {
        return localSuperheroes
    }

    fun getSuperhero(id: String): Superhero? {
        return localSuperheroes.find { it.id == id }
    }
}