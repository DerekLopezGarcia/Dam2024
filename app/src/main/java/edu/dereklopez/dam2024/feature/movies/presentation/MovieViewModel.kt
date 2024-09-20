package edu.dereklopez.dam2024.feature.movies.presentation
import androidx.lifecycle.ViewModel
import edu.dereklopez.dam2024.feature.movies.domain.GetMoviesUseCase
import edu.dereklopez.dam2024.feature.movies.domain.Movie

class MovieViewModel (private val getMovieUseCase: GetMoviesUseCase) : ViewModel() {
    fun viewCreated() : List <Movie> {
        return getMovieUseCase.invoke()
    }
}