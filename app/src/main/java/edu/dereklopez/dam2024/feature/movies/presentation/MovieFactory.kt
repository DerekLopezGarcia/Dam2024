package edu.dereklopez.dam2024.feature.movies.presentation

import android.content.Context
import edu.dereklopez.dam2024.feature.movies.data.MovieDataRepository
import edu.dereklopez.dam2024.feature.movies.data.local.MovieXmlLocalDataSource
import edu.dereklopez.dam2024.feature.movies.data.remote.MovieMockRemoteDataSource
import edu.dereklopez.dam2024.feature.movies.domain.GetMovieUseCase
import edu.dereklopez.dam2024.feature.movies.domain.GetMoviesUseCase

class MovieFactory(private val context: Context) {

    private val movieMockRemote = MovieMockRemoteDataSource()
    private val movieLocal = MovieXmlLocalDataSource(context)
    private val movieDataRepository = MovieDataRepository(movieLocal, movieMockRemote)
    private val getMoviesUseCase = GetMoviesUseCase(movieDataRepository)
    private val getMovieUseCase = GetMovieUseCase(movieDataRepository)

    fun buildViewModel(): MoviesViewModel {
        return MoviesViewModel(getMoviesUseCase)
    }

    fun buildMovieDetailViewModel(): MovieDetailViewModel {
        return MovieDetailViewModel(getMovieUseCase)
    }
}