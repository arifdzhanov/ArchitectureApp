package com.lafet.architectureapp.data

import com.lafet.architectureapp.core.data.Mapper
import com.lafet.architectureapp.data.dto.CityDto
import com.lafet.architectureapp.data.local.GeoLocalDataSource
import com.lafet.architectureapp.data.remote.GeoRemoteDataSource
import com.lafet.architectureapp.domain.model.City
import com.lafet.architectureapp.domain.GeoRepository

class GeoDataRepositoryImpl(
    private val source: GeoRemoteDataSource,
    private val local: GeoLocalDataSource,
    private val mapper: Mapper<CityDto, City>
) : GeoRepository {

    override suspend fun getCities(): List<City> {
        val list = source.getCities()
        local.saveCities(list)
        return list.map { mapper.mapFromObject(it) }
    }
}