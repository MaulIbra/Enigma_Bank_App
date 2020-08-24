package com.example.live_code_enigma.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.live_code_enigma.R
import com.example.live_code_enigma.model.Transaction

/**
 * Created by Maulana Ibrahim on 24/August/2020
 * Email maulibrahim19@gmail.com
 */
class TransactionListRecycleAdapter(val transactionList:List<Transaction>):RecyclerView.Adapter<TransactionListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.transaction_list_item, parent, false)
        return TransactionListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return transactionList.size
    }

    override fun onBindViewHolder(holder: TransactionListViewHolder, position: Int) {
        holder.transactionDate.text = transactionList[position].transactionDate
        holder.amount.text = "$${transactionList[position].amount}"
        if (transactionList[position].status == 1){
            holder.imageStatus.setImageResource(R.drawable.ic_attach_money_red24dp)
        }else{
            holder.imageStatus.setImageResource(R.drawable.ic_attach_money_green_24dp)
        }
    }
}