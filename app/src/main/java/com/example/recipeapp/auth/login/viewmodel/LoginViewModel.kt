package com.example.recipeapp.auth.login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class LoginViewModel():ViewModel() {
    private val _userSignedIn = MutableLiveData<Boolean>()
    val userSignedIn : LiveData<Boolean> = _userSignedIn
    val auth = Firebase.auth
    fun isUserSignedIn(email :String , password: String){
        viewModelScope.launch {
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                _userSignedIn.value = it.isSuccessful
            }
        }
    }
}