package com.onedev.demo.service

import com.onedev.demo.entity.User
import com.onedev.demo.repository.AuthRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AuthServiceImpl : AuthService {

    @Autowired
    private lateinit var authRepository: AuthRepository

    override fun login(user: User): User? {
        return authRepository.login(user.email, user.password)
    }

    override fun register(user: User): User? {
        return authRepository.register(user.name, user.email, user.password)
    }
}