package com.example.live_code_enigma.api

import com.example.live_code_enigma.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Created by Maulana Ibrahim on 24/August/2020
 * Email maulibrahim19@gmail.com
 */

interface AuthenticationServiceApi {
    @POST(ApiEndPoint.GET_USER_BY_ID)
    fun getUser(@Body user: User): Call<WrapperResponse>
}