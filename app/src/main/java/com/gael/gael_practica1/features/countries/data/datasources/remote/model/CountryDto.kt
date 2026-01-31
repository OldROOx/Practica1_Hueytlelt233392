package com.gael.gael_practica1.features.countries.data.datasources.remote.model

import com.google.gson.annotations.SerializedName

data class CountryDto(
    val name: NameDto,
    val cca2: String,
    val capital: List<String>?, // Agregado el ?
    val region: String,
    val idd: IddDto?, // Agregado el ?
    val currencies: Map<String, CurrencyDto>?, // Agregado el ?
    val languages: Map<String, String>? // Agregado el ?
)

data class NameDto(
    @SerializedName("common") val common: String,
    @SerializedName("official") val official: String
)

data class CurrencyDto(
    @SerializedName("name") val name: String,
    @SerializedName("symbol") val symbol: String
)

data class IddDto(
    @SerializedName("root") val root: String?,
    @SerializedName("suffixes") val suffixes: List<String>?
)

data class DemonymDto(
    @SerializedName("f") val feminine: String,
    @SerializedName("m") val masculine: String
)