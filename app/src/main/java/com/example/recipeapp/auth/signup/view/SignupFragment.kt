package com.example.recipeapp.auth.signup.view

import android.content.Context
import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.recipeapp.R
import com.example.recipeapp.auth.signup.repo.SignupRepo
import com.example.recipeapp.auth.signup.repo.SignupRepoImp
import com.example.recipeapp.auth.signup.viewmodel.SignupViewModel
import com.example.recipeapp.auth.signup.viewmodel.SignupViewModelFactory
import com.example.recipeapp.database.LocalDataSource
import com.example.recipeapp.database.LocalDataSourceImp
import com.example.recipeapp.database.User
import com.example.recipeapp.databinding.FragmentSignupBinding
import com.example.recipeapp.home.repo.HomeRepoImp
import com.example.recipeapp.home.viewmodel.HomeViewModel
import com.example.recipeapp.home.viewmodel.HomeViewModelFactory
import com.example.recipeapp.network.APIClient
import com.google.android.material.textfield.TextInputLayout


class SignupFragment : Fragment() {
    private lateinit var _binding: FragmentSignupBinding
    private lateinit var signUpViewModel: SignupViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignupBinding.inflate(inflater, container, false)
        val view = _binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
          gettingViewModelReady(requireContext()
          )
        signUpViewModel.emailExist.observe(requireActivity()){
            Toast.makeText(requireContext(), "hmm", Toast.LENGTH_SHORT).show()
            Toast.makeText(requireContext(), "$it", Toast.LENGTH_SHORT).show()
            if(it==true){
                Toast.makeText(requireContext(), "An account with this email already exists.", Toast.LENGTH_SHORT).show()
            }
            else{
                signUpViewModel.addUser(User(_binding.etEmail.editText?.text.toString(),_binding.etPassword.editText?.text.toString()))
            }

        }
        signUpViewModel.userAdded.observe(requireActivity()){
            if(it==true){
                val action= SignupFragmentDirections.actionSignupFragmentToLoginFragment()
                Toast.makeText(requireContext(), " Your account has been successfully created!", Toast.LENGTH_SHORT).show()
                findNavController().navigate(action)
            }
        }
        _binding.btnSignup.setOnClickListener {
            if(checkAllFields(_binding.etEmail,_binding.etPassword,_binding.etRePassword)){
                signUpViewModel.isEmailExists(_binding.etEmail.editText?.text.toString())
            }

        }
        _binding.tvSignin.setOnClickListener {
            val action = SignupFragmentDirections.actionSignupFragmentToLoginFragment()
            findNavController().navigate(action)
        }
    }

    private fun checkAllFields(emailEt : TextInputLayout, passwordEt: TextInputLayout, reEnterPasswordEt: TextInputLayout): Boolean{
        val email = emailEt.editText?.text.toString()
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
        if(passwordEt.editText?.text?.length!!<8){
            passwordEt.error = "password should be 8 characters at least "
            return false
        }else{
            passwordEt.error= null
        }
        if(reEnterPasswordEt.editText?.text.toString()==""){
            reEnterPasswordEt.error = "This field is required"
            return false
        }else if(reEnterPasswordEt.editText?.text.toString()!=passwordEt.editText?.text.toString()){
            reEnterPasswordEt.error = "Password doesn't match"
        }else{
            reEnterPasswordEt.error=null
        }
        return true
    }
    private fun gettingViewModelReady(context: Context) {

        val signupViewModelFactory = SignupViewModelFactory(
            SignupRepoImp(
                 LocalDataSourceImp(context)
            )
        )
        signUpViewModel = ViewModelProvider(owner = this, factory = signupViewModelFactory)[SignupViewModel::class.java]
    }

}