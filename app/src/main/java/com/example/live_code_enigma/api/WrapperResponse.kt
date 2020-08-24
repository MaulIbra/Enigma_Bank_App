package com.example.live_code_enigma.api

/**
 * Created by Maulana Ibrahim on 24/August/2020
 * Email maulibrahim19@gmail.com
 */

class WrapperResponse(
    var statusCode:Int,
    var message:String,
    val data: Any
)