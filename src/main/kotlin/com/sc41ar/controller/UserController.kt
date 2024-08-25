package com.sc41ar.controller

import com.sc41ar.domains.User
import com.sc41ar.service.UserService
import com.sc41ar.utils.JWTGenerator
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.cookie.Cookie
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import org.slf4j.LoggerFactory


@Controller("/users")
open class UserController(private val userService: UserService, private val generator: JWTGenerator) {

    @Post("/login")
    open fun login(
        @NotBlank @Body("username") username: String,
        @NotNull @NotBlank @Body("password") password: String
    ): HttpResponse<User?> {

        logger.info("trying to log with ${username}")

        var user = userService.login(username, password)

        if (user == null)
            return HttpResponse.badRequest()

        var token = generator.generate(username)

        return HttpResponse.created(user).status(200).cookie(Cookie.of("userId", user?.id.toString())).cookie(Cookie.of("jwt", token))

    }

    companion object {
        private val logger = LoggerFactory.getLogger(UserController::class.java)
    }

}