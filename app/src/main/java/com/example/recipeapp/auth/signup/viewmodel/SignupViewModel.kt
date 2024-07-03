package com.example.recipeapp.auth.signup.viewmodel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipeapp.auth.signup.model.User
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class SignupViewModel(val context: Context) :ViewModel() {
    private val _userAdded = MutableLiveData<Boolean>()
    val userAdded : LiveData<Boolean> = _userAdded
    private val _emailExists = MutableLiveData<Boolean>()
    val emailExist : LiveData<Boolean> = _emailExists
    private var auth: FirebaseAuth = FirebaseAuth.getInstance()
    private var firebaseDatabase= Firebase.firestore
     fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            auth.createUserWithEmailAndPassword(user.email, user.password).addOnCompleteListener {
                    task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    hashMapOf(
                        "userEmail" to user?.email,
                    )
                    firebaseDatabase.collection("Users")
                        .document(user!!.uid)
                        .set(hashMapOf(
                            "userEmail" to user?.email,
                            "userId" to user?.uid
                        ))
                        .addOnSuccessListener {
                            _userAdded.value= true
                        }
                        .addOnFailureListener {
                            _userAdded.value= false
                        }
                } else {
                    _userAdded.value= false
                }
            }
        }
        }
    fun isEmailExists(email: String){

        firebaseDatabase.collection("Users")
            .get()
            .addOnSuccessListener { result ->
                var flag = true
                for (document in result) {
                   flag = (email==document.get("userEmail"))
                    Log.d("flag", "isEmailExists:$flag ")
                }
                _emailExists.value=flag
            }

    }

}