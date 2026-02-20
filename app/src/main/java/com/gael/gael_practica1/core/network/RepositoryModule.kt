package com.gael.gael_practica1.core.di

import com.gael.gael_practica1.features.countries.data.repositories.CountriesRepositoryImpl
import com.gael.gael_practica1.features.countries.domain.repositories.CountriesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCountriesRepository(
        countriesRepositoryImpl: CountriesRepositoryImpl
    ): CountriesRepository
}