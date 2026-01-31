package com.gael.gael_practica1.features.countries.domain.entities

data class Country(
    val commonName: String,
    val officialName: String,
    val capital: String,
    val region: String,
    val phoneCode: String,
    val language: String,
    val demonym: String,
    val currency: String,
    val flagUrl: String
)
