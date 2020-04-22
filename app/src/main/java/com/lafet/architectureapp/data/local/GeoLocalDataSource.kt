package com.lafet.architectureapp.data.local

import com.lafet.architectureapp.data.dto.CityDto

interface GeoLocalDataSource {

    suspend fun saveCities(list: List<CityDto>)
}