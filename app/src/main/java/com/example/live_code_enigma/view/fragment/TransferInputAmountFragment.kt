package com.example.live_code_enigma.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.example.live_code_enigma.R
import com.example.live_code_enigma.common.validationInput
import com.example.live_code_enigma.model.Transaction
import com.example.live_code_enigma.viewmodel.AuthenticationViewModel
import com.example.live_code_enigma.viewmodel.TransactionViewModel
import kotlinx.android.synthetic.main.fragment_transfer_input_amount.*

class TransferInputAmountFragment : Fragment(),View.OnClickListener {
    val transactionViewModel by activityViewModels<TransactionViewModel>()
    lateinit var navController: NavController

    lateinit var recepientId:String
    lateinit var bankName:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_transfer_input_amount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recepientId = arguments?.getString("recipientId").toString()
        bankName = arguments?.getString("bankName").toString()
        navController = Navigation.findNavController(view)
        btnNext.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0){
            btnNext-> {
                val userId = 629620
                val amount = etAmount.text.toString()
                val description = etDescription.text.toString()
                if (validationInput(amount,description)){
                    val transaction = Transaction(
                        userId = userId,
                        amount = amount.toInt(),
                        bankName = bankName,
                        recipientId = recepientId.toInt(),
                        description = description
                    )
                    transactionViewModel.createTransaction(transaction)
                    transactionViewModel.getHistoryTransaction(userId)
                    navController.navigate(R.id.toTransferConfirmation)
                }else{
                    Toast.makeText(context,"input can't be empty",Toast.LENGTH_SHORT).show()
                }

            }
        }
    }

}
