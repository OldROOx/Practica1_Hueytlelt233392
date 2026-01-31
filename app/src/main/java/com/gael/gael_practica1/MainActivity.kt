package com.gael.gael_practica1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gael.gael_practica1.core.di.AppContainer
import com.gael.gael_practica1.features.countries.data.datasources.remote.mapper.toDomain
import com.gael.gael_practica1.features.countries.data.datasources.remote.model.CountryDto
import com.gael.gael_practica1.features.countries.data.datasources.remote.model.IddDto
import com.gael.gael_practica1.features.countries.data.datasources.remote.model.NameDto
import com.gael.gael_practica1.features.countries.domain.entities.Country
import com.gael.gael_practica1.features.countries.presentation.components.CountryCard
import com.gael.gael_practica1.features.countries.presentation.screens.CountriesScreen
import com.gael.gael_practica1.features.countries.presentation.viewmodels.CountriesViewModel
import com.gael.gael_practica1.features.countries.presentation.viewmodels.CountriesViewModelFactory
import com.gael.gael_practica1.ui.theme.Gael_practica1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // 1. Inicializamos el AppContainer que centraliza la red
        val appContainer = AppContainer()

        // 2. Obtenemos el UseCase directamente desde el módulo de países
        // Esto es mucho más limpio que crear el repositorio aquí mismo.
        val getCountriesUseCase = appContainer.countriesModule.getCountriesUseCase

        setContent {
            Gael_practica1Theme {
                // 3. Pasamos el UseCase a la fábrica del ViewModel
                val viewModel: CountriesViewModel = viewModel(
                    factory = CountriesViewModelFactory(getCountriesUseCase)
                )

                // 4. Cargamos la pantalla principal
                CountriesScreen(viewModel = viewModel)
            }
        }
    }
}

// --- PREVIEW CON DATOS REALES DE LA API ---

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CountriesApiDataPreview() {
    Gael_practica1Theme {
        // Ejemplo de datos reales de la API para validar el Mapper y la UI
        val andorraData = CountryDto(
            name = NameDto(common = "Andorra", official = "Principality of Andorra"),
            cca2 = "AD",
            capital = listOf("Andorra la Vella"),
            region = "Europe",
            idd = IddDto(root = "+3", suffixes = listOf("76")),
            currencies = null,
            languages = null,
            demonyms = null
        )

        // Usamos tu función de extensión toDomain para transformar el DTO
        val countryEntity = andorraData.toDomain()

        // Mostramos la tarjeta para verificar el diseño
        CountryCard(country = countryEntity)
    }
}