package com.gael.gael_practica1.features.countries.data.datasources.remote.model

import com.google.gson.annotations.SerializedName

data class CountryDto(
    @SerializedName("name") val name: NameDto,
    @SerializedName("capital") val capital: List<String>?,
    @SerializedName("currencies") val currencies: Map<String, CurrencyDto>?,
    @SerializedName("region") val region: String,
    @SerializedName("idd") val idd: IddDto?,
    @SerializedName("languages") val languages: Map<String, String>?,
    @SerializedName("demonyms") val demonyms: Map<String, Map<String, DemonymDto>>?,
    @SerializedName("cca2") val cca2: String // <--- NUEVO: Código de 2 letras (ej: "BE", "MX")
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