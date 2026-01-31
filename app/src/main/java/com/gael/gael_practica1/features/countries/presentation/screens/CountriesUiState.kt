package com.gael.gael_practica1.features.countries.presentation.screens

import com.gael.gael_practica1.features.countries.domain.entities.Country

sealed interface CountriesUiState {
    data class Success(val countries: List<Country>) : CountriesUiState
    object Error : CountriesUiState
    object Loading : CountriesUiState
}