package com.lafet.architectureapp.data.interceptors

import com.lafet.architectureapp.core.data.Error
import com.lafet.architectureapp.core.data.NetworkChecker
import okhttp3.Interceptor
import okhttp3.Response

class ConnectivityInterceptor (
    private val checker: NetworkChecker
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response =
        if (checker.isInternetConnectionEnabled()) chain.proceed(chain.request())
        else throw Error.OfflineError
}