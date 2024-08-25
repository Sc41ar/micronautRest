package com.sc41ar.service

import com.sc41ar.domains.Transaction
import com.sc41ar.domains.User
import com.sc41ar.domains.enums.TransactionCategoryEnum
import com.sc41ar.repository.TransactionRepository
import com.sc41ar.repository.UserRepository
import jakarta.inject.Singleton

@Singleton
open class TransactionService(
    private val transactionRepository: TransactionRepository,
    private val userRepository: UserRepository
) {


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