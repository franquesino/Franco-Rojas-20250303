package com.example.franco_rojas_20250303.model

import com.google.gson.annotations.SerializedName

data class BitcoinResponse(
    @SerializedName("version") val version: String,
    @SerializedName("autor") val autor: String,
    @SerializedName("codigo") val codigo: String,
    @SerializedName("nombre") val nombre: String,
    @SerializedName("unidad_medida") val unidadMedida: String,
    @SerializedName("serie") val serie: List<BitcoinSerie>
)

data class BitcoinSerie(
    @SerializedName("fecha") val fecha: String,
    @SerializedName("valor") val valor: Double
)
