package com.gael.gael_practica1.features.countries.data.datasources.remote.mapper

import com.gael.gael_practica1.features.countries.data.datasources.remote.model.CountryDto
import com.gael.gael_practica1.features.countries.domain.entities.Country

fun CountryDto.toDomain(): Country {
    // Extraemos la primera moneda e idioma disponibles de los mapas dinámicos
    val firstCurrency = this.currencies?.values?.firstOrNull()
    val firstLanguage = this.languages?.values?.firstOrNull()

    return Country(
        commonName = this.name.common,
        officialName = this.name.official,
        // Si la lista de capitales está vacía, ponemos "N/A"
        capital = this.capital?.firstOrNull() ?: "N/A",
        region = this.region,
        // Unimos el root (+3) con el primer sufijo (76) para tener +376
        phoneCode = "${this.idd?.root ?: ""}${this.idd?.suffixes?.firstOrNull() ?: ""}",
        currencyName = firstCurrency?.name ?: "N/A",
        currencySymbol = firstCurrency?.symbol ?: "",
        language = firstLanguage ?: "N/A",
        // Generamos la URL de la bandera usando el cca2 que agregamos al DTO
        flagUrl = "https://flagsapi.com/${this.cca2}/shiny/64.png"
    )
}