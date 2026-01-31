package com.gael.gael_practica1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gael.gael_practica1.core.di.AppContainer
import com.gael.gael_practica1.features.countries.domain.entities.Country
import com.gael.gael_practica1.features.countries.presentation.screens.CountriesScreen
import com.gael.gael_practica1.features.countries.presentation.screens.CountryDetailScreen
import com.gael.gael_practica1.features.countries.presentation.viewmodels.CountriesViewModel
import com.gael.gael_practica1.features.countries.presentation.viewmodels.CountriesViewModelFactory
import com.gael.gael_practica1.ui.theme.Gael_practica1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val appContainer = AppContainer()
        val getCountriesUseCase = appContainer.countriesModule.getCountriesUseCase

        setContent {
            Gael_practica1Theme {
                val viewModel: CountriesViewModel = viewModel(
                    factory = CountriesViewModelFactory(getCountriesUseCase)
                )

                // Lógica de navegación simple por estado
                var selectedCountry by remember { mutableStateOf<Country?>(null) }

                if (selectedCountry == null) {
                    CountriesScreen(
                        viewModel = viewModel,
                        onCountryClick = { country -> selectedCountry = country }
                    )
                } else {
                    CountryDetailScreen(
                        country = selectedCountry!!,
                        onBack = { selectedCountry = null }
                    )
                }
            }
        }
    }
}