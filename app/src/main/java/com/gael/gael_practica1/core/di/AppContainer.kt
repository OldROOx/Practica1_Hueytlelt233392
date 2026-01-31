package com.gael.gael_practica1.core.di

import com.gael.gael_practica1.BuildConfig
import com.gael.gael_practica1.core.network.CountriesApi
import com.gael.gael_practica1.features.countries.di.CountriesModule
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppContainer {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val countriesApi: CountriesApi by lazy {
        retrofit.create(CountriesApi::class.java)
    }

    // CENTRALIZAMOS el acceso a las dependencias de países aquí
    val countriesModule: CountriesModule by lazy {
        CountriesModule(countriesApi)
    }
}