package com.lafet.architectureapp.core.vm

import kotlinx.coroutines.launch

fun BaseVm.request(
    operationBuilderFunc: CoroutineWorkBuilder.() -> Unit
) = this.launch {
    val builder = CoroutineWorkBuilder().apply { operationBuilderFunc() }
    try {
        builder.progressFunction?.invoke(this, true)
        builder.workFunction?.invoke(this)
    } catch (error: Throwable) {
        builder.errorFunction?.invoke(this, error)
    } finally {
        builder.progressFunction?.invoke(this, false)
    }
}