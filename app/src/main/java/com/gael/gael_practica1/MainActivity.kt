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

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Gael_practica1Theme {
                CountriesScreen() // Hilt inyectará el ViewModel aquí
            }
        }
    }
}