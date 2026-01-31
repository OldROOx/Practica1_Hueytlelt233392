package com.gael.gael_practica1.features.countries.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.gael.gael_practica1.features.countries.domain.entities.Country

@Composable
fun CountryCard(
    country: Country,
    modifier: Modifier = Modifier,
    onClick: () -> Unit // Nuevo parámetro
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() }, // Habilitamos el click
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = country.flagUrl,
                contentDescription = "Flag of ${country.commonName}",
                modifier = Modifier.size(64.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(text = country.commonName, style = MaterialTheme.typography.titleLarge)
                Text(text = "Capital: ${country.capital}", style = MaterialTheme.typography.bodyMedium)
                Text(text = "Moneda: ${country.currencyName} (${country.currencySymbol})", style = MaterialTheme.typography.bodySmall)
                Text(text = "Tel: ${country.phoneCode}", style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}