package edu.dereklopez.dam2024.feature.superheroes.domain

interface SuperheroRepository {
    suspend fun getSuperheroes(): List<Superhero>
    suspend fun getSuperhero(id: String): Superhero?
}