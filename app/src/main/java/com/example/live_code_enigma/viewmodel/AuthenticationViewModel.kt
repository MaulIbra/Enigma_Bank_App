package com.example.live_code_enigma.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.live_code_enigma.api.AuthenticationServiceApi
import com.example.live_code_enigma.api.TransactionServiceApi
import com.example.live_code_enigma.config.RetrofitBuilder
import com.example.live_code_enigma.model.Transaction
import com.example.live_code_enigma.model.User
import com.example.live_code_enigma.repository.AuthenticationRepository
import com.example.live_code_enigma.repository.TransactionRepository

/**
 * Created by Maulana Ibrahim on 24/August/2020
 * Email maulibrahim19@gmail.com
 */
class AuthenticationViewModel : ViewModel() {

    private val authenticationRepository: AuthenticationRepository

    init {
        val authenticationServiceApi =
            RetrofitBuilder.createRetrofit().create(AuthenticationServiceApi::class.java)
        authenticationRepository =
            AuthenticationRepository(
                authenticationServiceApi
            )
    }

    val userLogin: LiveData<User> = authenticationRepository.userLogin

    fun getUser(user: User) {
        authenticationRepository.getUser(user)
    }

}