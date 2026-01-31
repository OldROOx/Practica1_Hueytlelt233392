package com.gael.gael_practica1.features.countries.domain.repositories

import com.gael.gael_practica1.features.countries.domain.entities.Country

interface CountriesRepository {
    // Definimos que queremos obtener una lista de nuestra entidad "limpia"
    suspend fun getCountries(): List<Country>
}