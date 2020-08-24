package com.example.live_code_enigma.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.live_code_enigma.api.TransactionServiceApi
import com.example.live_code_enigma.config.RetrofitBuilder
import com.example.live_code_enigma.model.Transaction
import com.example.live_code_enigma.repository.TransactionRepository

/**
 * Created by Maulana Ibrahim on 24/August/2020
 * Email maulibrahim19@gmail.com
 */

class TransactionViewModel : ViewModel() {
    private val transactionRepository: TransactionRepository

    init {
        val transactionServiceApi =
            RetrofitBuilder.createRetrofit().create(TransactionServiceApi::class.java)
        transactionRepository =
            TransactionRepository(
                transactionServiceApi
            )
    }

    val transactionList: LiveData<List<Transaction>> = transactionRepository.transactionList


    fun getHistoryTransaction(id:Int) {
        transactionRepository.getHistoryTransaction(id)
    }

    fun createTransaction(transaction: Transaction) {
        transactionRepository.createTransaction(transaction)
    }
}