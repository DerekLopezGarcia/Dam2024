package edu.dereklopez.dam2024.feature.movies.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import edu.dereklopez.dam2024.R
import edu.dereklopez.dam2024.feature.movies.data.MovieDataRepository
import edu.dereklopez.dam2024.feature.movies.data.remote.MovieMockRemoteDataSource
import edu.dereklopez.dam2024.feature.movies.domain.GetMoviesUseCase
import edu.dereklopez.dam2024.feature.movies.domain.Movie

class MovieActivity : AppCompatActivity() {

    private val MovieFactory: MovieFactory = MovieFactory()
    private val viewModel = MovieFactory.buildViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val movies = viewModel.viewCreated()
        bindData(movies)

    }

    private fun bindData(movies: List<Movie>) {
        findViewById<TextView>(R.id.movie_id_1).text = movies[0].id
        findViewById<TextView>(R.id.movie_title_1).text = movies[0].title
        findViewById<LinearLayout>(R.id.layout1).setOnClickListener {
            val movie = viewModel.itemsSelected(movies[0].id)
            movie?.let {
                Log.d("@dev", "Movie selected: ${it.title}")
            }

        }

        findViewById<TextView>(R.id.movie_id_2).text = movies[1].id
        findViewById<TextView>(R.id.movie_title_2).text = movies[1].title
        findViewById<LinearLayout>(R.id.layout2).setOnClickListener {
            val movie = viewModel.itemsSelected(movies[1].id)
            movie?.let {
                Log.d("@dev", "Movie selected: ${it.title}")
            }
        }
        findViewById<TextView>(R.id.movie_id_3).text = movies[2].id
        findViewById<TextView>(R.id.movie_title_3).text = movies[2].title
        findViewById<LinearLayout>(R.id.layout3).setOnClickListener {
            val movie = viewModel.itemsSelected(movies[2].id)
            movie?.let {
                Log.d("@dev", "Movie selected: ${it.title}")
            }
        }
    }
}
