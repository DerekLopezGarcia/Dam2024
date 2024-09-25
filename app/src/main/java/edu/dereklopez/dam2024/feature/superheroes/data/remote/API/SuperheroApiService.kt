package edu.dereklopez.dam2024.feature.superheroes.data.remote.API

import edu.dereklopez.dam2024.feature.superheroes.domain.Superhero
import retrofit2.http.GET
import retrofit2.http.Path

interface SuperheroApiService{
    @GET("all.json")
    suspend fun getSuperheroes(): List<Superhero>
    @GET("id/{id}.json")
    suspend fun getSuperhero(@Path("id") id: String): Superhero
    @GET("name/{name}.json")
    suspend fun getSuperheroByName(@Path("name") name: String): Superhero

}