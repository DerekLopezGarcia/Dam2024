package edu.dereklopez.dam2024.feature.superheroes.data.local

import android.content.Context
import edu.dereklopez.dam2024.R
import edu.dereklopez.dam2024.feature.superheroes.domain.Superhero


class SuperheroXmlLocalDataSource(private val context: Context) {
    private val sharedPref = context.getSharedPreferences(
        context.getString(R.string.name_file_xml), Context.MODE_PRIVATE
    )
    private val editor = sharedPref.edit()
    fun saveSuperhero(superhero: Superhero) {
        sharedPref.edit().apply() {
            putString("id", superhero.id)
            putString("name", superhero.name)
            putString("poster", superhero.photo)
            apply()
        }
    }

    fun find(): Superhero {
        val name = sharedPref.getString("name", "")
        val id = sharedPref.getString("id", "")
        val photo = sharedPref.getString("photo", "")
        return Superhero(id!!, name!!, photo!!)
    }

    fun delete() {
        sharedPref.edit().clear().apply()
    }

    fun deletebyid(id: String) {
        sharedPref.edit().remove(id).apply()
    }

}