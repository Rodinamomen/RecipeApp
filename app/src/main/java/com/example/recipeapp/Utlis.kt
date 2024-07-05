package com.example.recipeapp

import android.provider.ContactsContract.CommonDataKinds.Email
import com.google.firebase.auth.FirebaseAuth

class Utlis {
    companion object{
        private val auth = FirebaseAuth.getInstance()
        private var userEmail: String = ""
        fun getEmailLoggedIn(): String {
            if (auth.currentUser != null) {
                userEmail = auth.currentUser!!.email.toString()
            }
            return userEmail
        }
    }
}