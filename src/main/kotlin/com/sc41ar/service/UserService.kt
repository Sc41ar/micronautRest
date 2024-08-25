package com.sc41ar.service

import com.sc41ar.domains.User
import com.sc41ar.repository.UserRepository
import com.sc41ar.utils.PasswordUtils
import jakarta.inject.Singleton

@Singleton
class UserService(private val userRepository: UserRepository, private val passwordUtils: PasswordUtils) {
    fun login(username: String, password: String): User? {
        var user = userRepository.findByUsername(username)

        if (user != null && !passwordUtils.checkPassword(password, user.password)) {
            return null
        }
        return user
    }
}