package com.gael.gael_practica1.features.countries.di

import com.gael.gael_practica1.core.network.CountriesApi
import com.gael.gael_practica1.features.countries.data.repositories.CountriesRepositoryImpl
import com.gael.gael_practica1.features.countries.domain.repositories.CountriesRepository
import com.gael.gael_practica1.features.countries.domain.usecases.GetCountriesUseCase

/**
 * Módulo para organizar la creación de dependencias de la característica de Países.
 * En inyección manual, esto sirve como una capa de abstracción.
 */
class CountriesModule(private val countriesApi: CountriesApi) {

    // Provee la implementación del repositorio
    private val countriesRepository: CountriesRepository by lazy {
        CountriesRepositoryImpl(countriesApi)
    }

    // Provee el caso de uso necesario para el ViewModel
    val getCountriesUseCase: GetCountriesUseCase by lazy {
        GetCountriesUseCase(countriesRepository)
    }
}