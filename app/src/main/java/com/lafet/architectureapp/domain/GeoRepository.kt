package com.lafet.architectureapp.domain

import com.lafet.architectureapp.domain.model.City

interface GeoRepository {

    suspend fun getCities(): List<City>
}