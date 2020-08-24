package com.example.live_code_enigma.repository

import androidx.lifecycle.MutableLiveData
import com.example.live_code_enigma.api.AuthenticationServiceApi
import com.example.live_code_enigma.api.WrapperResponse
import com.example.live_code_enigma.model.Transaction
import com.example.live_code_enigma.model.User
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
class AuthenticationRepository(val authenticationServiceApi: AuthenticationServiceApi) {

    val userLogin: MutableLiveData<User> = MutableLiveData()

    fun getUser(user: User) {
        authenticationServiceApi.getUser(user).enqueue(object : Callback<WrapperResponse> {
            override fun onFailure(call: Call<WrapperResponse>, t: Throwable) {
                println(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<WrapperResponse>,
                response: Response<WrapperResponse>
            ) {
                val responseMovie = response.body()
                val res = responseMovie?.data
                val gson = Gson()
                userLogin.value = gson.fromJson(gson.toJson(res), User::class.java)
            }
        })
    }
}