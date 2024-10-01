package edu.dereklopez.dam2024.feature.movies.presentation

import edu.dereklopez.dam2024.feature.movies.data.MovieDataRepository
import edu.dereklopez.dam2024.feature.movies.data.remote.MovieMockRemoteDataSource
import edu.dereklopez.dam2024.feature.movies.domain.GetMovieUseCase
import edu.dereklopez.dam2024.feature.movies.domain.GetMoviesUseCase

class MovieFactory {
    fun buildViewModel(): MoviesViewModel {
        return MoviesViewModel(
            GetMoviesUseCase(MovieDataRepository(MovieMockRemoteDataSource())),
            GetMovieUseCase(MovieDataRepository(MovieMockRemoteDataSource()))
        )
    }
}