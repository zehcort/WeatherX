package com.zehcort.domain.utils

sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null,
    val stacktrace: Array<StackTraceElement>? = null
) {
    class Loading<T>(data: T? = null) : Resource<T>(data = data)
    class Success<T>(data: T? = null) : Resource<T>(data = data)
    class Error<T>(message: String, stacktrace: Array<StackTraceElement>) :
        Resource<T>(message = message, stacktrace = stacktrace)
}