package edu.dereklopez.dam2024.feature.movies.presentation
import androidx.lifecycle.ViewModel
import edu.dereklopez.dam2024.feature.movies.domain.GetMovieUseCase
import edu.dereklopez.dam2024.feature.movies.domain.GetMoviesUseCase
import edu.dereklopez.dam2024.feature.movies.domain.Movie

class MoviesViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val getMovieUseCase: GetMovieUseCase
) : ViewModel() {
    fun viewCreated() : List <Movie> {
        return getMoviesUseCase.invoke()
    }

    fun itemsSelected(id: String): Movie? {
        return getMovieUseCase.invoke(id)
    }
}