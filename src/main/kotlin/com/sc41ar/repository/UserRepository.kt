package com.sc41ar.repository

import com.sc41ar.domains.User
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface UserRepository : CrudRepository<User, Long> {

    fun findByUsername(username: String): User?
}