package edu.dereklopez.dam2024.feature.movies.domain

interface MovieRepository {
    fun getMovies(): List<Movie>
}