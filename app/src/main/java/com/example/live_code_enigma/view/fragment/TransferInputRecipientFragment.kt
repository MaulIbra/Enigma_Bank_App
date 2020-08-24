package com.example.live_code_enigma.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs

import com.example.live_code_enigma.R
import com.example.live_code_enigma.common.validationInput
import com.example.live_code_enigma.viewmodel.TransactionViewModel
import kotlinx.android.synthetic.main.fragment_transfer_input_recipient.*

class TransferInputRecipientFragment : Fragment(),View.OnClickListener {

    lateinit var navController: NavController
    lateinit var userId:String

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
                val recepientId = etRecipient.text.toString()
                val selectedBank = spinnerBank.selectedItem.toString()
                if (validationInput(recepientId,selectedBank)){
                    var bundle = bundleOf(
                        "recipientId" to recepientId,
                        "bankName" to selectedBank
                    )
                    navController.navigate(R.id.toTransferInputAmountFragment,bundle)
                }else{
                    Toast.makeText(context,"input can't be empty",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}
