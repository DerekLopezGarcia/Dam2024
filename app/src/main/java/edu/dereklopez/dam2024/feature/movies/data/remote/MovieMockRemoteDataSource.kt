package edu.dereklopez.dam2024.feature.movies.data.remote

import edu.dereklopez.dam2024.feature.movies.data.local.MovieXmlLocalDataSource
import edu.dereklopez.dam2024.feature.movies.domain.Movie

class MovieMockRemoteDataSource {

    private val movies = listOf(
        Movie("1", "title1", "poster1"),
        Movie("2", "title2", "poster2"),
        Movie("3", "title3", "poster3."),
        Movie(title = "title4", poster = "poster4", id = "4")
    )

    fun getMovies(): List<Movie> {
        return movies
    }

    fun getMovie(movieId: String): Movie? {
        return movies.firstOrNull { movie -> //renombro el it por movie
            //it es un objeto Movie del listado
            movie.id == movieId
        }
    }
}