package com.example.recipeapp.network

import com.example.recipeapp.home.model.Recipe
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("search.php?")
    suspend fun getAllMeals(@Query("s") randomChar: Char): Recipe
}