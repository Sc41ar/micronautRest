package com.sc41ar.utils

import io.jsonwebtoken.Jwts
import jakarta.inject.Singleton
import java.util.*

@Singleton
class JWTGenerator  {

    private val key = Jwts.SIG.HS512.key().build()

   fun generate(username: String): String {
        val now = Date()
        val expiration = Date(now.time + 7200000)

        val accessToken = Jwts.builder()
            .subject(username)
            .issuedAt(now)
            .expiration(expiration)
            .signWith(key)
            .compact()

        return accessToken
    }

    fun validateToken(token : String) : Boolean{
        return try {
            val claims = Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)

           return true
        } catch (e: Exception) {
            return false
        }

    }

}