package edu.dereklopez.dam2024.feature.superheroes.domain

interface SuperheroRepository {
    fun getSuperheroes(): List<Superhero>
}