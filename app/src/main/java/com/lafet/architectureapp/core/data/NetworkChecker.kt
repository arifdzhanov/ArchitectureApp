package com.lafet.architectureapp.core.data

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

class NetworkChecker(context: Context) {

    private val connectivityManager by lazy { context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager }

    /**
     * Checks if the device has any active internet connection.
     *
     * @return True if network connection enabled, otherwise returns false.
     */
    fun isInternetConnectionEnabled(): Boolean {
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true
        return isConnected
    }


}