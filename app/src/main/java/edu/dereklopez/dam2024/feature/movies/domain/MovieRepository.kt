package edu.dereklopez.dam2024.feature.movies.domain

import edu.dereklopez.dam2024.feature.movies.domain.Movie

interface MovieRepository {

    fun getMovies(): List<Movie>
    fun getMovie(movieId: String): Movie?
}