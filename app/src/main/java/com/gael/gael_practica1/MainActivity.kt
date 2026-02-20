package com.gael.gael_practica1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import com.gael.gael_practica1.features.countries.domain.entities.Country
import com.gael.gael_practica1.features.countries.presentation.screens.CountriesScreen
import com.gael.gael_practica1.features.countries.presentation.screens.CountryDetailScreen
import com.gael.gael_practica1.features.countries.presentation.viewmodels.CountriesViewModel
import com.gael.gael_practica1.ui.theme.Gael_practica1Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Gael_practica1Theme {
                val viewModel: CountriesViewModel = hiltViewModel()
                var selectedCountry by remember { mutableStateOf<Country?>(null) }

                if (selectedCountry == null) {
                    CountriesScreen(
                        viewModel = viewModel,
                        onCountryClick = { selectedCountry = it }
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