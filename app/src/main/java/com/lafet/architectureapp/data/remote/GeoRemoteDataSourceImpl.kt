package com.lafet.architectureapp.data.remote

import com.lafet.architectureapp.data.dto.CityDto

class GeoRemoteDataSourceImpl(
    private val api: Api
) : GeoRemoteDataSource {

    override suspend fun getCities(): List<CityDto> {
        val limit = 10
        val nextOffset = 0
        return api.getCities(limit, nextOffset).data
    }
}