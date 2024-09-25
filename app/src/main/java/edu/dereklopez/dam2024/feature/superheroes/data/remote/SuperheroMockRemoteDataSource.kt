package edu.dereklopez.dam2024.feature.superheroes.data.remote

import edu.dereklopez.dam2024.feature.superheroes.domain.Superhero

class SuperheroMockRemoteDataSource {
    val localSuperheroes = listOf(
        Superhero("1", "Super", "https://example.com/poster1.jpg"),
        Superhero("2", "Super", "https://example.com/poster2.jpg"),
        Superhero("3", "Super", "https://example.com/poster3.jpg")
    )

    fun getSuperheroes(): List<Superhero> {
        return localSuperheroes
    }

    fun getSuperhero(id: String): Superhero? {
        return localSuperheroes.find { it.id == id }
    }
}