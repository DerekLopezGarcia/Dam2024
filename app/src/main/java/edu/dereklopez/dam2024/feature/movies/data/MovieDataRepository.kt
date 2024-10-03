package edu.dereklopez.dam2024.feature.movies.data

import edu.dereklopez.dam2024.feature.movies.data.local.MovieXmlLocalDataSource
import edu.dereklopez.dam2024.feature.movies.data.remote.MovieMockRemoteDataSource
import edu.dereklopez.dam2024.feature.movies.domain.Movie
import edu.dereklopez.dam2024.feature.movies.domain.MovieRepository

class MovieDataRepository(
    private val local: MovieXmlLocalDataSource,
    private val mockRemoteDataSource: MovieMockRemoteDataSource
) :
    MovieRepository {
    override fun getMovies(): List<Movie> {
        val movies = local.findAll()
        if (movies.isEmpty()) {
            val movies = mockRemoteDataSource.getMovies()
            local.saveAll(movies)
            return movies
        } else {
            return movies
        }
    }
    override fun getMovie(movieId: String): Movie? {
        val localMovie = local.findByid(movieId)
        if (localMovie == null){
            mockRemoteDataSource.getMovie(movieId)?.let {
                local.saveMovie(it)
                return it
            }
        }
        return localMovie
    }
}