package com.example.recipeapp.auth.login.view

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.recipeapp.R
import com.example.recipeapp.auth.login.viewmodel.LoginViewModel
import com.example.recipeapp.databinding.FragmentLoginBinding
import com.example.recipeapp.databinding.FragmentSignupBinding
import com.google.android.material.textfield.TextInputLayout


class LoginFragment : Fragment() {
    private lateinit var _binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentLoginBinding.inflate(inflater,container,false)
        val view = _binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val loginViewModel = LoginViewModel()
        loginViewModel.userSignedIn.observe(requireActivity()){ data ->
            if(data){
              val action = LoginFragmentDirections.actionLoginFragmentToHomeFragment()
              findNavController().navigate(action)
            }else{
                Toast.makeText(requireContext(), "The email or password you entered is incorrect.", Toast.LENGTH_SHORT).show()
            }

        }
        _binding.btnSignin.setOnClickListener {
            if( checkAllFields(_binding.etEmail,_binding.etPassword)){
                loginViewModel.isUserSignedIn(_binding.etEmail.editText?.text.toString(),_binding.etPassword.editText?.text.toString())
            }

        }
        _binding.tvRegister.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToSignupFragment()
            findNavController().navigate(action)
        }
    }
    }

    private fun checkAllFields(emailEt : TextInputLayout, passwordEt: TextInputLayout): Boolean{
        var email = emailEt.editText?.text.toString()
        if(email==""){
            emailEt.error = "This field is required"
            return false
        }else{
            emailEt.error = null
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailEt.error = "Check email fromat"
            return false
        }
        if(passwordEt.editText?.text.toString() ==""){
            emailEt.error = "This field is required"
            return false
        }else{
            emailEt.error= null
        }
        return true
    }