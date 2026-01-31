package com.gael.gael_practica1.features.countries.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gael.gael_practica1.features.countries.domain.usecases.GetCountriesUseCase

class CountriesViewModelFactory(
    private val getCountriesUseCase: GetCountriesUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CountriesViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CountriesViewModel(getCountriesUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}