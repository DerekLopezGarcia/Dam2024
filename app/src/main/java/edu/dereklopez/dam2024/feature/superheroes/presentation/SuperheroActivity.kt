package edu.dereklopez.dam2024.feature.superheroes.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import edu.dereklopez.dam2024.R
import edu.dereklopez.dam2024.feature.superheroes.data.local.SuperheroXmlLocalDataSource
import edu.dereklopez.dam2024.feature.superheroes.domain.Superhero

class SuperheroActivity : AppCompatActivity() {
    private val SuperheroFactory: SuperheroFactory = SuperheroFactory()
    private val viewModel = SuperheroFactory.buildViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superhero)
        val superheroes = viewModel.viewCreated()
        bindData(superheroes)

    }

    private fun bindData(superheroes: List<Superhero>) {
        findViewById<TextView>(R.id.movie_id_1).text = superheroes[0].id
        findViewById<TextView>(R.id.movie_title_1).text = superheroes[0].name
        findViewById<LinearLayout>(R.id.layout1).setOnClickListener {
            val superhero = viewModel.itemsSelected(superheroes[0].id)
            superhero?.let {
                Log.d("@dev", "Superhero selected: ${it.name}")
            }
        }
        findViewById<TextView>(R.id.movie_id_2).text = superheroes[1].id
        findViewById<TextView>(R.id.movie_title_2).text = superheroes[1].name
        findViewById<LinearLayout>(R.id.layout2).setOnClickListener {
            val superhero = viewModel.itemsSelected(superheroes[1].id)
            superhero?.let {
                Log.d("@dev", "Superhero selected: ${it.name}")
            }
        }
        findViewById<TextView>(R.id.movie_id_3).text = superheroes[2].id
        findViewById<TextView>(R.id.movie_title_3).text = superheroes[2].name
        findViewById<LinearLayout>(R.id.layout3).setOnClickListener {
            val superhero = viewModel.itemsSelected(superheroes[2].id)
            superhero?.let {
                Log.d("@dev", "Superhero selected: ${it.name}")
            }
        }
    }
    private fun testxml() {
        val xmlDataSource = SuperheroXmlLocalDataSource(this)
        val superhero = viewModel.itemsSelected("1")
        superhero?.let {
            xmlDataSource.saveSuperhero(it)
        }
        val superhero2 = xmlDataSource.find()
        Log.d("@dev", "Superhero selected: ${superhero2.name}")
    }
}
