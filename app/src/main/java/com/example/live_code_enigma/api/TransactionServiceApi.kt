package com.example.live_code_enigma.api

import com.example.live_code_enigma.model.Transaction
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

/**
 * Created by Maulana Ibrahim on 24/August/2020
 * Email maulibrahim19@gmail.com
 */
interface TransactionServiceApi {

    @GET(ApiEndPoint.GET_TRANSACTION)
    fun getHistoryTransaction(@Path("id") id:Int): Call<WrapperResponse>

    @POST(ApiEndPoint.POST_TRANSACTION)
    fun createTransaction(@Body transaction: Transaction): Call<WrapperResponse>

}