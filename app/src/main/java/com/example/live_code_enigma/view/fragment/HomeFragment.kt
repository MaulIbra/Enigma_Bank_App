package com.example.live_code_enigma.view.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.live_code_enigma.R
import com.example.live_code_enigma.viewmodel.AuthenticationViewModel
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(),View.OnClickListener {

    val authenticationViewModel by activityViewModels<AuthenticationViewModel>()
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        btnTransfer.setOnClickListener(this)
        btnHistory.setOnClickListener(this)
        btnPhone.setOnClickListener(this)
        authenticationViewModel.userLogin.observe(viewLifecycleOwner, Observer {
            tvSaldo.text = it.balance.toString()
        })
    }

    override fun onClick(p0: View?) {
        when(p0){
            btnTransfer -> navController.navigate(R.id.toTransactionActivity)
            btnHistory -> navController.navigate(R.id.toTransactionListFragment)
            btnPhone -> {
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:085776088632")
                startActivity(intent)
            }
        }
    }
}
