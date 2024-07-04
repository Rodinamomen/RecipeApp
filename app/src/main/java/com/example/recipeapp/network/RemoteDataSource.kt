package com.example.recipeapp.network

import com.example.recipeapp.home.model.Recipe

interface RemoteDataSource {
    suspend fun getAllMeals(randomChar: Char): Recipe
}