package com.lafet.architectureapp.domain

import com.lafet.architectureapp.core.domain.UseCase
import com.lafet.architectureapp.domain.model.City

class GetCitiesUseCase(
    private val repo: GeoRepository
) : UseCase<List<City>, Unit>() {

    override suspend fun operation(params: Unit?): List<City> {
        return repo.getCities()
    }
}