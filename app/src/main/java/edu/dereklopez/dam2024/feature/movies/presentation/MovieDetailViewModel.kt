package edu.dereklopez.dam2024.feature.movies.presentation

import androidx.lifecycle.ViewModel
import edu.dereklopez.dam2024.feature.movies.domain.GetMovieUseCase
import edu.dereklopez.dam2024.feature.movies.domain.Movie

class MovieDetailViewModel(
    private val getMovieUseCase: GetMovieUseCase
) : ViewModel() {

    fun viewCreated(movieId: String): Movie? {
        return getMovieUseCase.invoke(movieId)
    }
}