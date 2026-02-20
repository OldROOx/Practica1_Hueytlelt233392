package com.gael.gael_practica1.features.countries.domain.usecases

import com.gael.gael_practica1.features.countries.domain.entities.Country
import com.gael.gael_practica1.features.countries.domain.repositories.CountriesRepository
import javax.inject.Inject

class GetCountriesUseCase @Inject constructor(
    private val repository: CountriesRepository
) {
    suspend operator fun invoke(): List<Country> {
        return repository.getCountries().sortedBy { it.commonName }
    }
}