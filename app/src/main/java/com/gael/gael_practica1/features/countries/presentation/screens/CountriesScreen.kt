package com.gael.gael_practica1.features.countries.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import com.gael.gael_practica1.features.countries.presentation.components.CountryCard
import com.gael.gael_practica1.features.countries.presentation.viewmodels.CountriesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountriesScreen(viewModel: CountriesViewModel) {
    val state = viewModel.countriesUiState

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text("Mundo de Países") })
        }
    ) { padding ->
        when (state) {
            is CountriesUiState.Loading -> {
                // Pantalla de carga
                Box(modifier = androidx.compose.ui.Modifier.fillMaxSize(), contentAlignment = androidx.compose.ui.Alignment.Center) {
                    CircularProgressIndicator()
                }
            }
            is CountriesUiState.Success -> {
                // Lista de países
                LazyColumn(modifier = androidx.compose.ui.Modifier.padding(padding)) {
                    items(state.countries) { country ->
                        CountryCard(country = country)
                    }
                }
            }
            is CountriesUiState.Error -> {
                // Pantalla de error
                Text(text = "Error al cargar datos. Revisa tu conexión.")
            }
        }
    }
}