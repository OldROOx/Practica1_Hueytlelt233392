package com.gael.gael_practica1.features.countries.domain.entities

data class Country(
    val commonName: String,
    val officialName: String,
    val capital: String,
    val region: String,
    val phoneCode: String,    // codigo numerico
    val currencyName: String,
    val currencySymbol: String,
    val language: String,
    val flagUrl: String
)