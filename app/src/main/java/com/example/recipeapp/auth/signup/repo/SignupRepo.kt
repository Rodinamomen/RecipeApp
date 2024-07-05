package com.example.recipeapp.auth.signup.repo

import com.example.recipeapp.database.User

interface SignupRepo {
    suspend fun insertUser(user: User)
}