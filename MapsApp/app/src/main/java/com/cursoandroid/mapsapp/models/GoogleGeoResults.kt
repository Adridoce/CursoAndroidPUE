package com.cursoandroid.mapsapp.models

data class GoogleGeoResults(
    val results: List<Results>
)

data class Results(
    val geometry: Geometry,
    val formatted_address: String
)

data class Geometry(
    val location: Location
)

data class Location (
    val lat: Double,
    val lng: Double
)