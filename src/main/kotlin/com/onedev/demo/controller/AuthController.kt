package com.onedev.demo.controller

import com.onedev.demo.entity.User
import com.onedev.demo.response.BaseResponse
import com.onedev.demo.service.AuthService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/auth")
class AuthController {

    @Autowired
    private lateinit var authService: AuthService

    @GetMapping("/login")
    fun login(
        @RequestBody user: User
    ): BaseResponse<User> {
        val data = authService.login(user)
        return if (data != null) {
            BaseResponse(
                message = "Login Success",
                status = true,
                data = authService.login(user)
            )
        } else {
            BaseResponse(
                message = "Login Failed - Incorrect Email or Password",
                status = false,
                data = null
            )
        }
    }

    @PostMapping("/register")
    fun register(
        @RequestBody user: User
    ): BaseResponse<User> {
        return BaseResponse(
            message = "Register Success",
            status = true,
            data = authService.register(user)
        )
    }
}