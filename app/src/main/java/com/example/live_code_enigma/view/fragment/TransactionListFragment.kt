package com.example.live_code_enigma.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.live_code_enigma.R
import com.example.live_code_enigma.view.adapter.TransactionListRecycleAdapter
import com.example.live_code_enigma.viewmodel.AuthenticationViewModel
import com.example.live_code_enigma.viewmodel.TransactionViewModel
import kotlinx.android.synthetic.main.fragment_transaction_list.*


class TransactionListFragment : Fragment() {

    private val transactionViewModel by activityViewModels<TransactionViewModel>()
    private val authenticationViewModel by activityViewModels<AuthenticationViewModel>()
    lateinit var transactionListRecycleAdapter: TransactionListRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_transaction_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvTransactionList.layoutManager = LinearLayoutManager(context)
        authenticationViewModel.userLogin.observe(viewLifecycleOwner, Observer {
            transactionViewModel.getHistoryTransaction(it.userId)

        })
        transactionViewModel.transactionList.observe(viewLifecycleOwner, Observer {
            transactionListRecycleAdapter = TransactionListRecycleAdapter(it)
            rvTransactionList.adapter = transactionListRecycleAdapter
        })
    }
}
