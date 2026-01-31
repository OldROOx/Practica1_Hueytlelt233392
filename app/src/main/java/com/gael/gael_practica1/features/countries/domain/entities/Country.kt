package com.gael.gael_practica1.features.countries.domain.entities

data class Country(
    val commonName: String,
    val officialName: String, // Este será tu "fullname"
    val capital: String,
    val region: String,
    val phoneCode: String,    // Combinación de idd.root + idd.suffixes
    val currencyName: String, // Ejemplo: "Euro"
    val currencySymbol: String, // Ejemplo: "€"
    val language: String,     // Idioma principal
    val flagUrl: String       // Construida con flagsapi.com y el cca2
)