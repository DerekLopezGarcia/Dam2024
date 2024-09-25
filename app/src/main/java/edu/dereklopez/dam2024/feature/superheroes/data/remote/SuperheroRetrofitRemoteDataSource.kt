package edu.dereklopez.dam2024.feature.superheroes.data.remote

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

class SuperheroRetrofitRemoteDataSource {
    private val baseUrl = "https://superheroapi.com/api/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(ScalarsConverterFactory.create())
        .build()
}