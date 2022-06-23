package com.onedev.demo.response

data class BaseResponse<T>(
    val message: String = "",
    val status: Boolean = false,
    val data: T? = null
)