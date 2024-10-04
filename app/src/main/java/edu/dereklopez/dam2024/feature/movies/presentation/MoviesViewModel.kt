package edu.dereklopez.dam2024.feature.movies.presentation

import androidx.lifecycle.ViewModel
import edu.dereklopez.dam2024.feature.movies.domain.GetMoviesUseCase
import edu.dereklopez.dam2024.feature.movies.domain.Movie

class MoviesViewModel(
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel() {

    fun viewCreated(): List<Movie> {
        return getMoviesUseCase.invoke()
    }
}