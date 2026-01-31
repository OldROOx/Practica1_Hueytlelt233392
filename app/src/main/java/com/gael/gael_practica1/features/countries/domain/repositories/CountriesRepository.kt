package com.gael.gael_practica1.features.countries.domain.repositories

import com.gael.gael_practica1.features.countries.domain.entities.Country

interface CountriesRepository {

    suspend fun getCountries(): List<Country>
}