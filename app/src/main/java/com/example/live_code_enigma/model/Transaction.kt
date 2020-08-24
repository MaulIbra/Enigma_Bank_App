package com.example.live_code_enigma.model

/**
 * Created by Maulana Ibrahim on 24/August/2020
 * Email maulibrahim19@gmail.com
 */
class Transaction(
    var userId:Int=0,
    var transactionDate:String="",
    var amount:Int=0,
    var bankName:String="",
    var recipientId:Int=0,
    var description:String="",
    var status:Int=0
)