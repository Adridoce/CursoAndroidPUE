package com.cursoandroid.mapsapp.models

import com.google.android.gms.maps.model.LatLng

data class LocationModel(
    val name: String,
    val coordinates: LatLng
)
