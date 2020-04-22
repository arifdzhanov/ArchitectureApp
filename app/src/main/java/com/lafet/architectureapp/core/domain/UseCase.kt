package com.lafet.architectureapp.core.domain

abstract class UseCase<T, in P> {

    protected abstract suspend fun operation(params: P? = null): T

    suspend fun execute(params: P? = null): T = operation(params)
}