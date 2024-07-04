package com.example.recipeapp.network

import com.example.recipeapp.home.model.Recipe

object APIClient :RemoteDataSource{
    override suspend fun getAllMeals(randomChar: Char): Recipe {
        return APIHelper.retrofit.create(APIService::class.java).getAllMeals(randomChar)
    }
}