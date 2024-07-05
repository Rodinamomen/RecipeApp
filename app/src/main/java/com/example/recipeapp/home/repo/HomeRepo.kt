package com.example.recipeapp.home.repo

import com.example.recipeapp.database.FavouriteList
import com.example.recipeapp.home.model.Recipe

interface HomeRepo {
    suspend fun getAllMeals(randomChar: Char): Recipe
    suspend fun insertIntoFavourites(favouriteList: FavouriteList)
    suspend fun isFavourite(userEmail: String,idMeal:String): Boolean
    suspend fun removeMealsByMealId(idMeal: String)
}