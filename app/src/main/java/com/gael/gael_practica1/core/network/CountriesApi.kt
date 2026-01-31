package com.gael.gael_practica1.core.network

import com.gael.gael_practica1.features.countries.data.datasources.remote.model.CountryDto
import retrofit2.http.GET
import retrofit2.http.Query

interface CountriesApi {
    // Definimos la petición GET al endpoint "all"
    @GET("all")
    suspend fun getAllCountries(
        // El @Query agrega "?fields=..." a la URL automáticamente
        @Query("fields") fields: String = "name,capital,currencies,region,idd,languages,demonyms,cca2"
    ): List<CountryDto>
}