package com.gael.gael_practica1.features.countries.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gael.gael_practica1.features.countries.presentation.components.CountryCard
import com.gael.gael_practica1.features.countries.presentation.viewmodels.CountriesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountriesScreen(
    viewModel: CountriesViewModel,
    onCountryClick: (com.gael.gael_practica1.features.countries.domain.entities.Country) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "COUNTRinfo",
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            OutlinedTextField(
                value = viewModel.searchQuery,
                onValueChange = { viewModel.onSearchQueryChange(it) },
                label = { Text("Buscar...", style = MaterialTheme.typography.labelLarge) },
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                textStyle = MaterialTheme.typography.bodyLarge
            )

            LazyColumn {
                items(viewModel.filteredCountries) { country ->
                    CountryCard(
                        country = country,
                        onClick = { onCountryClick(country) }
                    )
                }
            }
        }
    }
}