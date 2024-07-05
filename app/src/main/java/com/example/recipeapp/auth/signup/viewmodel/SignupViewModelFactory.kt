package com.example.recipeapp.auth.signup.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.recipeapp.auth.signup.repo.SignupRepo
import com.example.recipeapp.home.repo.HomeRepo
import com.example.recipeapp.home.viewmodel.HomeViewModel

class SignupViewModelFactory(val signupRepo: SignupRepo): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(SignupViewModel::class.java)) {
            SignupViewModel(signupRepo) as T
        } else {
            throw IllegalArgumentException("SignupRepo class not found")
        }
    }
}