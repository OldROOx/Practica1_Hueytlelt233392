package com.gael.gael_practica1.features.countries.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gael.gael_practica1.features.countries.domain.usecases.GetCountriesUseCase
import com.gael.gael_practica1.features.countries.presentation.screens.CountriesUiState
import kotlinx.coroutines.launch

class CountriesViewModel(
    private val getCountriesUseCase: GetCountriesUseCase
) : ViewModel() {

    // El estado que la UI observará
    var countriesUiState: CountriesUiState by mutableStateOf(CountriesUiState.Loading)
        private set

    init {
        getCountries()
    }

    fun getCountries() {
        viewModelScope.launch {
            countriesUiState = CountriesUiState.Loading
            countriesUiState = try {
                // Llamamos al caso de uso (Paso 3)
                val list = getCountriesUseCase()
                CountriesUiState.Success(list)
            } catch (e: Exception) {
                CountriesUiState.Error
            }
        }
    }
}