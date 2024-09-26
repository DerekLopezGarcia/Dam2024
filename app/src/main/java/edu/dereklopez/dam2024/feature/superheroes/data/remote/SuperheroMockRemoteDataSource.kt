package edu.dereklopez.dam2024.feature.superheroes.data.remote

import edu.dereklopez.dam2024.feature.superheroes.domain.Superhero

class SuperheroMockRemoteDataSource {
    val localSuperheroes = listOf(
        Superhero("1", "Super1", "a"),
        Superhero("2", "Super2", "b"),
        Superhero("3", "Super3", "c")
    )

    fun getSuperheroes(): List<Superhero> {
        return localSuperheroes
    }

    fun getSuperhero(id: String): Superhero? {
        return localSuperheroes.find { it.id == id }
    }
}