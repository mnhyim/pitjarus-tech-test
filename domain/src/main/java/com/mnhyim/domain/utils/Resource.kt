package com.mnhyim.domain.utils

sealed class Resource<T>(
    val code: Int? = null,
    val message: String? = null,
    val content: T? = null,
) {
    class Success<T>(code: Int?, content: T?) : Resource<T>(code = code, content = content)
    class Loading<T> : Resource<T>()
    class Error<T>(code: Int?, message: String?) : Resource<T>(code = code, message = message)
}