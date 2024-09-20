package edu.dereklopez.dam2024.feature.movies.data.remote

import edu.dereklopez.dam2024.feature.movies.domain.Movie

class MovieMockRemoteDataSource {
    fun getMovies(): List<Movie>{
        return listOf(
            Movie("1", "The Shawshank Redemption", "https://example.com/poster1.jpg"),
            Movie("2", "The Godfather", "https://example.com/poster2.jpg"),
            Movie("3", "The Dark Knight", "https://example.com/poster3.jpg")
        )
    }
}