package edu.dereklopez.dam2024.feature.movies.presentation

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.dereklopez.dam2024.R
import edu.dereklopez.dam2024.feature.movies.domain.Movie

class MoviesActivity : AppCompatActivity() {

    private lateinit var movieFactory: MovieFactory
    private lateinit var viewModel: MoviesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actvivity_movies)

        movieFactory = MovieFactory(this)
        viewModel = movieFactory.buildViewModel()

        val movies = viewModel.viewCreated()
        bindData(movies)
    }

    private fun bindData(movies: List<Movie>) {
        findViewById<TextView>(R.id.movie_id_1).text = movies[0].id
        findViewById<TextView>(R.id.movie_title_1).text = movies[0].title
        findViewById<LinearLayout>(R.id.layout_1).setOnClickListener {
            navigateToMovieDetail(movies[0].id)
        }

        findViewById<TextView>(R.id.movie_id_2).text = movies[1].id
        findViewById<TextView>(R.id.movie_title_2).text = movies[1].title
        findViewById<LinearLayout>(R.id.layout2).setOnClickListener {
            navigateToMovieDetail(movies[1].id)
        }

        findViewById<TextView>(R.id.movie_id_3).text = movies[2].id
        findViewById<TextView>(R.id.movie_title_3).text = movies[2].title
        findViewById<LinearLayout>(R.id.layout3).setOnClickListener {
            navigateToMovieDetail(movies[2].id)
        }

        findViewById<TextView>(R.id.movie_id_4).text = movies[3].id
        findViewById<TextView>(R.id.movie_title_4).text = movies[3].title
        findViewById<LinearLayout>(R.id.layout4).setOnClickListener {
            navigateToMovieDetail(movies[3].id)
        }
    }

    private fun navigateToMovieDetail(movieId: String) {
        startActivity(MovieDetailActivity.getIntent(this, movieId))
    }
}