package edu.dereklopez.dam2024.feature.movies.data.remote

import edu.dereklopez.dam2024.feature.movies.domain.Movie

class MovieMockRemoteDataSource {
    val localMovies = listOf(
        Movie("1", "The Shawshank Redemption", "https://example.com/poster1.jpg"),
        Movie("2", "The Godfather", "https://example.com/poster2.jpg"),
        Movie("3", "The Dark Knight", "https://example.com/poster3.jpg")
    )

    fun getMovies(): List<Movie> {
        return localMovies
    }
    fun getMovie(id: String): Movie? {
        return localMovies.find { it.id == id }
    }
}