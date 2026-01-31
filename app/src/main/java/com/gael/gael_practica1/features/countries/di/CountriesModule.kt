package com.gael.gael_practica1.features.countries.di

import com.gael.gael_practica1.core.network.CountriesApi
import com.gael.gael_practica1.features.countries.data.repositories.CountriesRepositoryImpl
import com.gael.gael_practica1.features.countries.domain.repositories.CountriesRepository
import com.gael.gael_practica1.features.countries.domain.usecases.GetCountriesUseCase


class CountriesModule(private val countriesApi: CountriesApi) {


    private val countriesRepository: CountriesRepository by lazy {
        CountriesRepositoryImpl(countriesApi)
    }


    val getCountriesUseCase: GetCountriesUseCase by lazy {
        GetCountriesUseCase(countriesRepository)
    }
}