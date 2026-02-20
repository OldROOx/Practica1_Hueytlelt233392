package com.gael.gael_practica1.features.countries.data.repositories

import com.gael.gael_practica1.core.network.CountriesApi
import com.gael.gael_practica1.features.countries.data.datasources.remote.mapper.toDomain
import com.gael.gael_practica1.features.countries.domain.entities.Country
import com.gael.gael_practica1.features.countries.domain.repositories.CountriesRepository
import jakarta.inject.Inject

class CountriesRepositoryImpl @Inject constructor(
    private val countriesApi: CountriesApi
) : CountriesRepository {

    override suspend fun getCountries(): List<Country> {

        val response = countriesApi.getAllCountries()


        return response.map { it.toDomain() }
    }
}