package com.example.live_code_enigma.view.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.live_code_enigma.R
import kotlinx.android.synthetic.main.transaction_list_item.view.*

/**
 * Created by Maulana Ibrahim on 24/August/2020
 * Email maulibrahim19@gmail.com
 */
class TransactionListViewHolder(view:View):RecyclerView.ViewHolder(view) {
    val transactionDate = view.findViewById<TextView>(R.id.tvTransactionDate)
    val amount = view.findViewById<TextView>(R.id.tvAmount)
    val imageStatus = view.findViewById<ImageView>(R.id.imgMoney)
}