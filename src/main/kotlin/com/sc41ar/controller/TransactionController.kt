package com.sc41ar.controller

import com.sc41ar.domains.Transaction
import com.sc41ar.domains.enums.TransactionCategoryEnum
import com.sc41ar.repository.TransactionRepository
import com.sc41ar.service.TransactionService
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.QueryValue
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull


@Controller("/transactions")
open class TransactionController(
    private val transactionRepository: TransactionRepository,
    private val transactionService: TransactionService
) {

    @Get("/getall")
    open fun getAll(
        @QueryValue("category") category: TransactionCategoryEnum = TransactionCategoryEnum.UNKNOWN,
        @QueryValue("user_id") userId: Long,
        @QueryValue("page") page: Int,
        @QueryValue("size") size: Int
    ): HttpResponse<List<Transaction>?> {

        var allTransactions: Page<Transaction> = transactionService.findTransactions(category, userId, page, size)


        return HttpResponse.ok(allTransactions.content)
    }

    @Post("/save")
    open fun save(
        @NotNull @Body("amount") amount: Long,
        @NotBlank @Body("category") category: String,
        @NotNull @Body("userId") userId: Long
    ): HttpResponse<Transaction?> {
        var transaction = transactionService.save(amount, category, userId)

        return HttpResponse.created(transaction)
    }

}