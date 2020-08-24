package com.example.live_code_enigma.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.example.live_code_enigma.R
import com.example.live_code_enigma.common.validationInput
import com.example.live_code_enigma.model.User
import com.example.live_code_enigma.viewmodel.AuthenticationViewModel
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment(),View.OnClickListener {

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
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        btnLogin.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0){
            btnLogin -> {
                val username = etUsername.text.toString()
                val password = etPassword.text.toString()
                if (validationInput(username,password)){
                    val user = User(
                        username = username,
                        password = password
                    )
                    authenticationViewModel.getUser(user)
                    navController.navigate(R.id.toHomeFragment)
                }else{
                    Toast.makeText(context,"Input can't be empty",Toast.LENGTH_SHORT).show()
                }

            }
        }
    }


}
