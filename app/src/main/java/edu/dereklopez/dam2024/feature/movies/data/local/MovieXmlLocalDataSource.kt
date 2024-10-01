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
        editor.putString("id", movie.id)
        editor.putString("title", movie.title)
        editor.putString("poster", movie.poster)
        editor.apply()
    }

    fun find(): Movie {
        val title = sharedPref.getString("title", "")
        val id = sharedPref.getString("id", "")
        val poster = sharedPref.getString("poster", "")
        return Movie(id!!, title!!, poster!!)
    }

    fun delete() {
        sharedPref.edit().clear().apply()
    }

    fun saveAll(movies: List<Movie>) {
        val editor = sharedPref.edit()
        movies.forEach { movie ->
            editor.putString(movie.id, gson.toJson(movie))
        }
        editor.apply()
    }

    fun removeByid(id: String) {
        val editor = sharedPref.edit()
        editor.remove(id)
        editor.apply()
    }
}
