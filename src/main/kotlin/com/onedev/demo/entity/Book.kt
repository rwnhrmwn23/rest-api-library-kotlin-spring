package com.onedev.demo.entity

import java.util.UUID

data class Book(
    val id: String = UUID.randomUUID().toString(),
    val title: String = "",
    val author: String = "",
    val linkImage: String = "",
    val userId: String = ""
)
