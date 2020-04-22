package com.lafet.architectureapp.data.remote

import com.lafet.architectureapp.data.dto.CityDto

interface GeoRemoteDataSource {

    suspend fun getCities(): List<CityDto>
}