package com.gael.gael_practica1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
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

        // 1. Habilitar diseño de borde a borde para Material 3
        enableEdgeToEdge()

        val appContainer = AppContainer()
        val getCountriesUseCase = appContainer.countriesModule.getCountriesUseCase

        setContent {
            // 2. Envolver TODA la app en tu tema personalizado
            Gael_practica1Theme {
                // 3. Surface es vital para que el fondo use tus colores de Material Builder
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel: CountriesViewModel = viewModel(
                        factory = CountriesViewModelFactory(getCountriesUseCase)
                    )

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
}