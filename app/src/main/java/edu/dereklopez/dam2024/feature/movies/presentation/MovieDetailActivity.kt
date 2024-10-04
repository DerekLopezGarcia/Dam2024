package edu.dereklopez.dam2024.feature.movies.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import edu.dereklopez.dam2024.R
import edu.dereklopez.dam2024.app.extensions.loadUrl
import edu.dereklopez.dam2024.feature.movies.domain.Movie

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var movieFactory: MovieFactory
    private lateinit var viewModel: MovieDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        movieFactory = MovieFactory(this)
        viewModel = movieFactory.buildMovieDetailViewModel()

        getMovieId()?.let { movieId ->
            viewModel.viewCreated(movieId)?.let { movie ->
                bindData(movie)
            }
        }
    }

    private fun getMovieId(): String? {
        return intent.getStringExtra(KEY_MOVIE_ID)
    }

    private fun bindData(movie: Movie) {
        val imageView = findViewById<ImageView>(R.id.poster)
        imageView.loadUrl(movie.poster)
    }

    companion object {
        val KEY_MOVIE_ID = "key_movie_id"

        fun getIntent(context: Context, movieId: String): Intent {
            val intent = Intent(context, MovieDetailActivity::class.java)
            intent.putExtra(KEY_MOVIE_ID, movieId)
            return intent
        }
    }
}