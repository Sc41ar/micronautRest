package com.sc41ar.service

import com.sc41ar.domains.Transaction
import com.sc41ar.domains.User
import com.sc41ar.domains.enums.TransactionCategoryEnum
import com.sc41ar.repository.TransactionRepository
import com.sc41ar.repository.UserRepository
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import jakarta.inject.Singleton

@Singleton
open class TransactionService(
    private val transactionRepository: TransactionRepository,
    private val userRepository: UserRepository
) {

    fun findTransactions(
        category: TransactionCategoryEnum,
        userId: Long,
        page: Int,
        size: Int
    ): Page<Transaction> {
        var allTransactions: Page<Transaction>

        when (category) {
            TransactionCategoryEnum.UNKNOWN -> allTransactions =
                transactionRepository.findByUser_idOrderByDate(userId, pageable = Pageable.from(page, size))

            else -> allTransactions = transactionRepository.findByCategoryAndUser_idOrderByDate(
                category,
                userId,
                pageable = Pageable.from(page, size)
            )
        }

        return allTransactions
    }


    fun save(amount: Long, category: String, userId: Long): Transaction {
        var enumCategory = when (category.uppercase()) {
            "EXPENSE" -> TransactionCategoryEnum.EXPENSE
            "INCOME" -> TransactionCategoryEnum.INCOME
            else -> TransactionCategoryEnum.UNKNOWN
        }
        var userOptional = userRepository.findById(userId)

        return transactionRepository.save(
            Transaction(
                null, amount = amount, category = enumCategory, user = userOptional.orElse(
                    User()
                )
            )
        )
    }

}