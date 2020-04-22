package com.lafet.architectureapp.ui.main.vm

import androidx.lifecycle.MutableLiveData
import com.lafet.architectureapp.core.vm.*
import com.lafet.architectureapp.domain.model.City
import com.lafet.architectureapp.domain.GetCitiesUseCase
import kotlin.error

class CitiesVm(
    private val getCitiesUseCase: GetCitiesUseCase
) : BaseVm() {

    val progressState = MutableLiveData<Boolean>()
    val itemsState = MutableLiveData<List<CityItem>>()
    val showToast = MutableLiveData<String>()

    private val mapper: (City) -> CityItem = { city ->
        with(city) {
            CityItem(
                id = id,
                name = name,
                country = country
            )
        }
    }

    init {
        request {
            progress { progressState.value = it }
            work {
                val cities = getCitiesUseCase.execute()
                itemsState.value = cities.map(mapper).toMutableList()
            }
            error { showToast.postValue("error") }
        }
    }
}

data class CityItem(
    val id: String,
    val name: String,
    val country: String
)