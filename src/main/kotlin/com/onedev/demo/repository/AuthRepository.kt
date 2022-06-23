package com.onedev.demo.repository

import com.onedev.demo.entity.User

interface AuthRepository {
    fun login(email: String, password: String): User?
    fun register(name: String, email: String, password: String): User?
}