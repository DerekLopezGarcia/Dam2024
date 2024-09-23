package edu.dereklopez.dam2024.feature.superheroes.domain

class GetSuperheroesUseCase(private val superheroRepository: SuperheroRepository) {
    operator fun invoke(): List<Superhero> {
        return superheroRepository.getSuperheroes()
    }

}