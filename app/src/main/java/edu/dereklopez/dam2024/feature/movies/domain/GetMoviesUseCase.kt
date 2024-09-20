package edu.dereklopez.dam2024.feature.movies.domain

class GetMoviesUseCase(private val movieRepository: MovieRepository) {
    operator fun invoke(): List<Movie>{
        return movieRepository.getMovies()

    }
}