package com.example.live_code_enigma.repository

import androidx.lifecycle.MutableLiveData
import com.example.live_code_enigma.api.TransactionServiceApi
import com.example.live_code_enigma.api.WrapperResponse
import com.example.live_code_enigma.model.Transaction
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type

/**
 * Created by Maulana Ibrahim on 24/August/2020
 * Email maulibrahim19@gmail.com
 */
class TransactionRepository(val transactionServiceApi: TransactionServiceApi) {

    val transactionList: MutableLiveData<List<Transaction>> = MutableLiveData()

    fun getHistoryTransaction(id:Int) {
        transactionServiceApi.getHistoryTransaction(id).enqueue(object : Callback<WrapperResponse> {
            override fun onFailure(call: Call<WrapperResponse>, t: Throwable) {
                println(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<WrapperResponse>,
                response: Response<WrapperResponse>
            ) {
                val responseMovie = response.body()
                val res = responseMovie?.data
                val listOfMyClassObject: Type = object : TypeToken<List<Transaction?>?>() {}.type
                val gson = Gson()
                val outputList: List<Transaction> = gson.fromJson(gson.toJson(res), listOfMyClassObject)
                transactionList.value = outputList
            }
        })
    }


    fun createTransaction(transaction: Transaction) {
        transactionServiceApi.createTransaction(transaction).enqueue(object : Callback<WrapperResponse> {
            override fun onFailure(call: Call<WrapperResponse>, t: Throwable) {
                println(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<WrapperResponse>,
                response: Response<WrapperResponse>
            ) {
                println("SUCCESS POST: $response")
            }
        })
    }

}