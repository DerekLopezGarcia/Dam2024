package edu.dereklopez.dam2024.feature.movies.data

import edu.dereklopez.dam2024.feature.movies.data.remote.MovieMockRemoteDataSource
import edu.dereklopez.dam2024.feature.movies.domain.Movie
import edu.dereklopez.dam2024.feature.movies.domain.MovieRepository

class MovieDataRepository (private val mockRemoteDataSource : MovieMockRemoteDataSource):
    MovieRepository {
    override fun getMovies() : List<Movie>{
        return mockRemoteDataSource.getMovies()
    }


}