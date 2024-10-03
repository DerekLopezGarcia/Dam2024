package edu.dereklopez.dam2024.feature.superheroes.data

import edu.dereklopez.dam2024.feature.superheroes.data.local.SuperheroXmlLocalDataSource
import edu.dereklopez.dam2024.feature.superheroes.data.remote.SuperheroMockRemoteDataSource
import edu.dereklopez.dam2024.feature.superheroes.domain.Superhero
import edu.dereklopez.dam2024.feature.superheroes.domain.SuperheroRepository

class SuperheroDataRepository(
    private val mockRemoteDataSource: SuperheroMockRemoteDataSource,
    private val local: SuperheroXmlLocalDataSource
) :
    SuperheroRepository {
    override fun getSuperheroes(): List<Superhero> {
        val superhero = local.findAll()
        if (superhero.isEmpty()) {
            val superheroes = mockRemoteDataSource.getSuperheroes()
            local.saveall(superheroes)
            return superheroes
        } else {
            return superhero
        }
    }

    override fun getSuperhero(id: String): Superhero? {
        val superhero = local.finfById(id)
        if (superhero == null) {
            mockRemoteDataSource.getSuperhero(id)?.let {
                local.save(it)
                return it
                }
        }
        return superhero
    }
}