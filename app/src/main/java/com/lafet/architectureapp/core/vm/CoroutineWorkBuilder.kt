package com.lafet.architectureapp.core.vm

import kotlinx.coroutines.CoroutineScope

class CoroutineWorkBuilder {
    internal var progressFunction: (suspend CoroutineScope.(Boolean) -> Unit)? = null
    internal var workFunction: (suspend CoroutineScope.() -> Unit)? = null
    internal var errorFunction: (suspend CoroutineScope.(Throwable) -> Unit)? = null
}

fun CoroutineWorkBuilder.progress(progressFunc: suspend CoroutineScope.(Boolean) -> Unit) {
    this.progressFunction = progressFunc
}

fun CoroutineWorkBuilder.work(workFunc: suspend CoroutineScope.() -> Unit) {
    this.workFunction = workFunc
}

fun CoroutineWorkBuilder.error(errorFunc: suspend CoroutineScope.(Throwable) -> Unit) {
    this.errorFunction = errorFunc
}