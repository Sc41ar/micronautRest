package com.sc41ar

import com.sc41ar.domains.User
import com.sc41ar.repository.UserRepository
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.BeforeAll

@MicronautTest
class RepositoryTest {

    @Inject
    val userRepository: UserRepository


    @BeforeAll
    fun beforeAll(userRepository: UserRepository)
    {
        userRepository.save(User(id = null, username = "user", password = "pass"))
    }
}