package com.sc41ar.utils

import io.micronaut.context.annotation.Bean
import java.security.MessageDigest
import java.util.*

@Bean
class PasswordUtils {
    fun hashPassword(password : String): String{
        val bytePass = password.toByteArray()
        val md = MessageDigest.getInstance("SHA-256")
        val digest = md.digest(bytePass)
        return Base64.getEncoder().encodeToString(digest)
    }

    fun checkPassword(inputPassword: String, hashedPassword: String?): Boolean {
        val inputHash = hashPassword(inputPassword)
        return inputHash == hashedPassword
    }
}