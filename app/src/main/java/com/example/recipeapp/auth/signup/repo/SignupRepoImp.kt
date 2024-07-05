package com.example.recipeapp.auth.signup.repo

import com.example.recipeapp.database.LocalDataSource
import com.example.recipeapp.database.User

class SignupRepoImp(val localDataSource: LocalDataSource):SignupRepo {
    override suspend fun insertUser(user: User) {
         localDataSource.insertUser(user)
    }
}