package com.example.recipeapp.home.repo

import com.example.recipeapp.home.model.Recipe

interface HomeRepo {
    suspend fun getAllMeals(randomChar: Char): Recipe
}