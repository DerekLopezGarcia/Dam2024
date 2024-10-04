package edu.dereklopez.dam2024.feature.movies.domain

import edu.dereklopez.dam2024.feature.movies.domain.Movie
import edu.dereklopez.dam2024.feature.movies.domain.MovieRepository

class GetMovieUseCase(private val movieRepository: MovieRepository) {

    operator fun invoke(movieId: String): Movie? {
        return movieRepository.getMovie(movieId)
    }
}