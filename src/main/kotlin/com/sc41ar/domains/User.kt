package com.sc41ar.domains


import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank


@Serdeable
@Entity
@Table(name = "users", schema = "public")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @NotBlank
    var username: String? = null

    @NotBlank
    var password: String? = null

    constructor()

    constructor(id: Long?, username: String?, password: String?) {
        this.id = id
        this.username = username
        this.password = password
    }
}