package edu.dereklopez.dam2024.feature.superheroes.data

import edu.dereklopez.dam2024.feature.superheroes.data.remote.SuperheroRetrofitRemoteDataSource
import edu.dereklopez.dam2024.feature.superheroes.domain.Superhero
import edu.dereklopez.dam2024.feature.superheroes.domain.SuperheroRepository

class SuperheroDataRepository(private val retrofitRemoteDataSource: SuperheroRetrofitRemoteDataSource) :
    SuperheroRepository {
    override suspend fun getSuperheroes(): List<Superhero> {
        return retrofitRemoteDataSource.getSuperheroes()
    }

    override suspend fun getSuperhero(id: String): Superhero? {
        return retrofitRemoteDataSource.getSuperhero(id)
    }

}