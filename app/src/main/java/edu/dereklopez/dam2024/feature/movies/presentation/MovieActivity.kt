package edu.dereklopez.dam2024.feature.movies.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import edu.dereklopez.dam2024.R
import edu.dereklopez.dam2024.feature.movies.data.MovieDataRepository
import edu.dereklopez.dam2024.feature.movies.data.remote.MovieMockRemoteDataSource
import edu.dereklopez.dam2024.feature.movies.domain.GetMoviesUseCase

class MovieActivity : AppCompatActivity() {

   private val MovieFactory : MovieFactory = MovieFactory()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel = MovieFactory.buildViewModel()
        viewModel.viewCreated()
        val movies = viewModel.viewCreated()
        Log.d("@dev",movies.toString())
    }
    override fun onStart(){
        super.onStart()

    }
    override fun onResume(){
        super.onResume()
}
    override fun onPause(){
        super.onPause()
    }
    override fun onStop(){
        super.onStop()
    }
    override fun onDestroy(){
        super.onDestroy()
    }
}