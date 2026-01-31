package com.gael.gael_practica1.features.countries.data.repositories

import com.gael.gael_practica1.core.network.CountriesApi
import com.gael.gael_practica1.features.countries.data.datasources.remote.mapper.toDomain
import com.gael.gael_practica1.features.countries.domain.entities.Country
import com.gael.gael_practica1.features.countries.domain.repositories.CountriesRepository

class CountriesRepositoryImpl(
    private val countriesApi: CountriesApi
) : CountriesRepository {

    override suspend fun getCountries(): List<Country> {
        // 1. Pedimos los datos a la API (devuelve List<CountryDto>)
        val response = countriesApi.getAllCountries()

        // 2. Usamos el Mapper para transformar cada DTO en una entidad de Dominio
        // El .map { it.toDomain() } es lo que conecta el Paso 1 con el Paso 2
        return response.map { it.toDomain() }
    }
}