package com.lafet.architectureapp.core.data

import java.io.IOException

sealed class Error(message: String? = null) : IOException(message) {
    data class ServerError(val httpStatusCode: Int, override val message: String) : Error(message)
    object UnauthorizedError : Error()
    object OfflineError : Error()
}