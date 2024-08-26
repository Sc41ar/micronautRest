package com.sc41ar.repository

import com.sc41ar.domains.Transaction
import com.sc41ar.domains.enums.TransactionCategoryEnum
import io.micronaut.data.annotation.Repository
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import io.micronaut.data.repository.CrudRepository
import io.micronaut.data.repository.PageableRepository
import java.util.*

@Repository
interface TransactionRepository: CrudRepository<Transaction, Long> {
    fun findByCategoryAndUser_idOrderByDate(categort:TransactionCategoryEnum, userId: Long, pageable: Pageable) : Page<Transaction>
    fun findByUser_idOrderByDate(userId: Long, pageable: Pageable) : Page<Transaction>
}