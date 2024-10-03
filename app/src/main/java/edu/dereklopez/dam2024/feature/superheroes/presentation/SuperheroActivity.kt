package edu.dereklopez.dam2024.feature.superheroes.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.dereklopez.dam2024.R
import edu.dereklopez.dam2024.feature.superheroes.domain.Superhero

class SuperheroActivity : AppCompatActivity() {
    private lateinit var superheroFactory: SuperheroFactory
    private lateinit var viewModel: SuperheroViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superhero)

        superheroFactory = SuperheroFactory(this)
        viewModel = superheroFactory.buildViewModel()

        val superheroes = viewModel.viewCreated()
        bindData(superheroes)
    }

    private fun bindData(superheroes: List<Superhero>) {
        findViewById<TextView>(R.id.superhero_id_1).text = superheroes[0].id
        findViewById<TextView>(R.id.superhero_name_1).text = superheroes[0].name
        findViewById<LinearLayout>(R.id.layout_1).setOnClickListener {
            val superhero: Superhero? = viewModel.itemSelected(superheroes[0].id)
            superhero?.let {
                Log.d("@dev", "Pelicula seleccionada: ${it.name}")
            }
        }
        findViewById<TextView>(R.id.superhero_id_2).text = superheroes[1].id
        findViewById<TextView>(R.id.superhero_name_2).text = superheroes[1].name

        findViewById<TextView>(R.id.superhero_id_3).text = superheroes[2].id
        findViewById<TextView>(R.id.superhero_name_3).text = superheroes[2].name

        findViewById<TextView>(R.id.superhero_id_4).text = superheroes[3].id
        findViewById<TextView>(R.id.superhero_name_4).text = superheroes[3].name
    }
}