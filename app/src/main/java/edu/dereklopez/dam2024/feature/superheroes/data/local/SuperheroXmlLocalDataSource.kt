package edu.dereklopez.dam2024.feature.superheroes.data.local

import android.content.Context
import com.google.gson.Gson
import edu.dereklopez.dam2024.feature.movies.domain.Movie
import edu.dereklopez.dam2024.feature.superheroes.domain.Superhero


class SuperheroXmlLocalDataSource(private val context: Context) {
    private val sharedPref = context.getSharedPreferences("superheroes", Context.MODE_PRIVATE)
    private val gson = Gson()

    fun save(superhero: Superhero) {
        val json = gson.toJson(superhero)
        sharedPref.edit().putString("superheroe", json).apply()
    }

    fun saveall(superheroes: List<Superhero>) {
        val json = gson.toJson(superheroes)
        sharedPref.edit().putString("superheroes", json).apply()
    }

    fun findAll(): List<Superhero> {
        val superheroes = ArrayList<Superhero>()
        val mapSuperheroes = sharedPref.all //as Map<String, String>
        mapSuperheroes.values.forEach { json ->
            val superhero = gson.fromJson(json.toString(), Superhero::class.java)
            superheroes.add(superhero)
        }
        return superheroes
    }

    fun finfById(id: String): Superhero? {
        val superhero = sharedPref.getString("superheroe", null)
        return gson.fromJson(superhero, Superhero::class.java)
    }

    fun deleteBy(id: String) {
        sharedPref.edit().remove("superheroe").apply()
    }

    fun deleteAll() {
        sharedPref.edit().clear().apply()
    }

}


