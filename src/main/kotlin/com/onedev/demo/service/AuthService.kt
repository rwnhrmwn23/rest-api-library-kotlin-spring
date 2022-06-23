package com.onedev.demo.service

import com.onedev.demo.entity.User

interface AuthService {
    fun login(user: User): User?
    fun register(user: User): User?
}