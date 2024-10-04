package edu.dereklopez.dam2024.feature.movies.data

import edu.dereklopez.dam2024.feature.movies.data.local.MovieXmlLocalDataSource
import edu.dereklopez.dam2024.feature.movies.data.remote.MovieMockRemoteDataSource
import edu.dereklopez.dam2024.feature.movies.domain.Movie
import edu.dereklopez.dam2024.feature.movies.domain.MovieRepository

/**
 * Naming: Modelo + DataRepository
 */
class MovieDataRepository(
    private val local: MovieXmlLocalDataSource,
    private val mockRemoteDataSource: MovieMockRemoteDataSource
) :
    MovieRepository {

    override fun getMovies(): List<Movie> {
        val moviesFromLocal = local.findAll()
        if (moviesFromLocal.isEmpty()) {
            val moviesFromRemote = mockRemoteDataSource.getMovies()
            local.saveAll(moviesFromRemote)
            return moviesFromRemote
        } else {
            return moviesFromLocal
        }
    }

    override fun getMovie(movieId: String): Movie? {
        val localMovie = local.findById(movieId)
        if (localMovie == null) {
            mockRemoteDataSource.getMovie(movieId)?.let {
                local.save(it)
                return it
            }
        }
        return localMovie
    }
}