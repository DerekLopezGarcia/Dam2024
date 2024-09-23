package edu.dereklopez.dam2024.feature.movies.domain

import edu.dereklopez.dam2024.feature.movies.data.MovieDataRepository
import edu.dereklopez.dam2024.feature.movies.data.remote.MovieMockRemoteDataSource

class GetMovieUseCase(private val movieRepository: MovieRepository) {
    operator fun invoke(id: String): Movie? {
        return movieRepository.getMovie(id)
    }

}