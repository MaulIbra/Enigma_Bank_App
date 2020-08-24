package com.example.live_code_enigma.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.example.live_code_enigma.R
import com.example.live_code_enigma.viewmodel.TransactionViewModel
import kotlinx.android.synthetic.main.fragment_transfer_input_recipient.*

class TransferInputRecipientFragment : Fragment(),View.OnClickListener {

    val transactionViewModel by activityViewModels<TransactionViewModel>()
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_transfer_input_recipient, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        btnNext.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0){
            btnNext-> {
                var bundle = bundleOf(
                    "recipientId" to etRecipient.text.toString(),
                    "bankName" to spinnerBank.selectedItem.toString()
                )
                navController.navigate(R.id.toTransferInputAmountFragment)
            }
        }
    }

}
