package edu.dereklopez.dam2024.feature.superheroes.data.remote

import edu.dereklopez.dam2024.feature.superheroes.data.remote.API.SuperheroApiService
import edu.dereklopez.dam2024.feature.superheroes.domain.Superhero
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

class SuperheroRetrofitRemoteDataSource {
    private val baseUrl = "https://superheroapi.com/api/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(ScalarsConverterFactory.create())
        .build()
    val apiService: SuperheroApiService = retrofit.create(SuperheroApiService::class.java)

    suspend fun getSuperheroes(): List<Superhero> {
        return apiService.getSuperheroes()
    }

    suspend fun getSuperhero(id: String): Superhero {
        return apiService.getSuperhero(id)

    }
}