package com.lafet.architectureapp.data.remote

import com.lafet.architectureapp.data.dto.CitiesDto
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("https://wft-geo-db.p.rapidapi.com/v1/geo/cities")
/*    @Headers(
        "x-rapidapi-host: wft-geo-db.p.rapidapi.com",
        "x-rapidapi-key: 1b7fd429dcmshff1ecc8fdcd5899p1c8c20jsn8d3bd07ee2fe"
    )*/
    suspend fun getCities(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): CitiesDto

}
