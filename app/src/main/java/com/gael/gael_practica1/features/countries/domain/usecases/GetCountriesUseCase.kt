package com.gael.gael_practica1.features.countries.domain.usecases

import com.gael.gael_practica1.features.countries.domain.entities.Country
import com.gael.gael_practica1.features.countries.domain.repositories.CountriesRepository

class GetCountriesUseCase(
    private val repository: CountriesRepository
) {
    // El operador 'invoke' permite llamar a la clase como si fuera una función
    suspend operator fun invoke(): List<Country> {
        // Aquí podríamos añadir lógica de ordenamiento si quisiéramos
        return repository.getCountries().sortedBy { it.commonName }
    }
}