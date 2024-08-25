package com.sc41ar.domains

import com.sc41ar.domains.enums.TransactionCategoryEnum
import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.*
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.time.LocalDateTime

@Serdeable
@Entity
class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Min(0)
    var amount: Long? = null

    var date: LocalDateTime? = null

    var category: TransactionCategoryEnum? = null

    @ManyToOne
    @JoinColumn(name = "user_id")
    var user: User? = null

    constructor()

    constructor(id: Long?, amount: Long, category: TransactionCategoryEnum, user: User?)
    {
        this.id = id
        this.amount = amount
        this.category = category
        this.date = LocalDateTime.now()
        this.user = user
    }

}