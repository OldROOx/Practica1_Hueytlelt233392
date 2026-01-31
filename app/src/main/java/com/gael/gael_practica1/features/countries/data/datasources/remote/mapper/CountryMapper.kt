package com.gael.gael_practica1.features.countries.data.datasources.remote.mapper

import com.gael.gael_practica1.features.countries.data.datasources.remote.model.CountryDto
import com.gael.gael_practica1.features.countries.domain.entities.Country

fun CountryDto.toDomain(): Country {
    // Extraemos de forma segura el primer valor de los mapas
    val firstCurrency = this.currencies?.values?.firstOrNull()
    val firstLanguage = this.languages?.values?.firstOrNull()

    return Country(
        commonName = this.name.common,
        officialName = this.name.official,
        // Si no hay capital, ponemos un texto amigable
        capital = this.capital?.firstOrNull() ?: "Sin capital",
        region = this.region,
        // Unimos el código de teléfono manejando nulos de IDD
        phoneCode = if (this.idd != null) {
            "${this.idd.root ?: ""}${this.idd.suffixes?.firstOrNull() ?: ""}"
        } else "N/A",
        currencyName = firstCurrency?.name ?: "N/A",
        currencySymbol = firstCurrency?.symbol ?: "",
        language = firstLanguage ?: "N/A",
        // Usamos cca2 para la bandera
        flagUrl = "https://flagsapi.com/${this.cca2}/shiny/64.png"
    )
}