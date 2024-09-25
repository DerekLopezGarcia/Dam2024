package edu.dereklopez.dam2024.feature.superheroes.domain

data class Superhero(
    val id: String,
    val name: String,
    val photo: String,
    val biography: String,
    val powerstats: String,
    val appearance: String,
    val work: String,
    val connections: String
)