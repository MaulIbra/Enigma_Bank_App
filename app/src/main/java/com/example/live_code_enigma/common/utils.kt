package com.example.live_code_enigma.common

/**
 * Created by Maulana Ibrahim on 24/August/2020
 * Email maulibrahim19@gmail.com
 */


fun validationInput(vararg values:String):Boolean{
    for (value in values){
        if (value.isEmpty()){
            return false
        }
    }
    return true
}