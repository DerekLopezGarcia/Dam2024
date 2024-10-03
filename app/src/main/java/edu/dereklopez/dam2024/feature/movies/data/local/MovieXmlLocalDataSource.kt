package edu.dereklopez.dam2024.feature.movies.data.local

import android.content.Context
import com.google.gson.Gson
import edu.dereklopez.dam2024.R
import edu.dereklopez.dam2024.feature.movies.domain.Movie

class MovieXmlLocalDataSource(private val context: Context) {
    private val sharedPref = context.getSharedPreferences(
        context.getString(R.string.name_file_xml), Context.MODE_PRIVATE
    )

    private val gson = Gson()
    fun saveMovie(movie: Movie) {
        val editor = sharedPref.edit()
        editor.putString(movie.id, gson.toJson(movie))
        editor.apply()
    }

    fun saveAll(movies: List<Movie>) {
        val editor = sharedPref.edit()
        movies.forEach { movie ->
            editor.putString(movie.id, gson.toJson(movie))
        }
        editor.apply()
    }

    fun findAll(): List<Movie> {
        val movies = ArrayList<Movie>()
        val mapMovies = sharedPref.all //as Map<String, String>
        mapMovies.values.forEach { jsonMovie ->
            val movie = gson.fromJson(jsonMovie as String, Movie::class.java)
            movies.add(movie)
        }
        return movies
    }

    fun findByid(id: String): Movie? {
        val jsonMovie = sharedPref.getString(id, null)
        return gson.fromJson(jsonMovie, Movie::class.java)
    }

    fun delete() {
        sharedPref.edit().clear().apply()
    }

    fun deleteById(movieId: String) {
        sharedPref.edit().remove(movieId).apply()
    }


}
