package com.lafet.architectureapp.data.interceptors

import com.lafet.architectureapp.core.data.Error
import okhttp3.Interceptor
import okhttp3.Response

class ErrorInterceptor () : Interceptor {

    private val unauthorizedRequests = hashSetOf<String>()

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)
        return when {
            response.isSuccessful || response.code() == HTTP_UNAUTHORIZED -> response
            else -> throw Error.ServerError(response.code(), response.message())
        }
    }

    companion object{
        private const val HTTP_UNAUTHORIZED = 401
    }
}