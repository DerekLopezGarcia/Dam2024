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
            val remoteMovies = mockRemoteDataSource.getMovies()
            local.saveAll(movies)
            return remoteMovies
        } else {
            return movies
        }
    }
    override fun getMovie(id: String): Movie? {
        val localMovie = local.findById(id)
        if (localMovie == null){
            mockRemoteDataSource.getMovie(id)?.let {
                local.saveMovie(it)
                return it
            }
        }
        return localMovie
    }
}