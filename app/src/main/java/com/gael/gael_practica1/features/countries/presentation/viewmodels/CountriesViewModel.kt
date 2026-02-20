package com.gael.gael_practica1.features.countries.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gael.gael_practica1.features.countries.domain.entities.Country
import com.gael.gael_practica1.features.countries.domain.usecases.GetCountriesUseCase
import com.gael.gael_practica1.features.countries.presentation.screens.CountriesUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject // CAMBIO: Usar javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel // AGREGAR: Necesario para Hilt
class CountriesViewModel @Inject constructor(
    private val getCountriesUseCase: GetCountriesUseCase
) : ViewModel() {

    var countriesUiState: CountriesUiState by mutableStateOf(CountriesUiState.Loading)
        private set

    var searchQuery by mutableStateOf("")
        private set

    val filteredCountries: List<Country>
        get() {
            val currentState = countriesUiState
            return if (currentState is CountriesUiState.Success) {
                if (searchQuery.isEmpty()) {
                    currentState.countries
                } else {
                    currentState.countries.filter { country ->
                        country.commonName.contains(searchQuery, ignoreCase = true) ||
                                country.capital.contains(searchQuery, ignoreCase = true) ||
                                country.phoneCode.contains(searchQuery)
                    }
                }
            } else emptyList()
        }

    init {
        getCountries()
    }

    fun getCountries() {
        viewModelScope.launch {
            countriesUiState = CountriesUiState.Loading
            countriesUiState = try {
                val list = getCountriesUseCase()
                CountriesUiState.Success(list)
            } catch (e: Exception) {
                CountriesUiState.Error
            }
        }
    }

    fun onSearchQueryChange(newQuery: String) {
        searchQuery = newQuery
    }
}