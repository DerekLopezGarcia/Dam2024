package edu.dereklopez.dam2024.feature.movies.domain

import edu.dereklopez.dam2024.feature.movies.domain.Movie
import edu.dereklopez.dam2024.feature.movies.domain.MovieRepository

/**
 * Naming: Verbo(Acción) + UseCase
 */
class GetMoviesUseCase(private val movieRepository: MovieRepository) {

    operator fun invoke(): List<Movie> {
        return movieRepository.getMovies()
    }
}