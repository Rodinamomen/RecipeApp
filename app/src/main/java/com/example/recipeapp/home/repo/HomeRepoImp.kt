package com.example.recipeapp.home.repo

import com.example.recipeapp.database.FavouriteList
import com.example.recipeapp.database.LocalDataSource
import com.example.recipeapp.home.model.Recipe
import com.example.recipeapp.network.RemoteDataSource

class HomeRepoImp(val remoteDataSource: RemoteDataSource,val localDataSource: LocalDataSource) : HomeRepo{
    override suspend fun getAllMeals(randomChar: Char): Recipe {
        return remoteDataSource.getAllMeals(randomChar)
    }

    override suspend fun insertIntoFavourites(favouriteList: FavouriteList) {
        localDataSource.insertIntoFavourites(favouriteList)
    }

    override suspend fun isFavourite(userEmail: String, idMeal: String): Boolean {
        return localDataSource.isFavourite(userEmail,idMeal)
    }

    override suspend fun removeMealsByMealId(idMeal: String) {
        localDataSource.removeMealsByMealId(idMeal)
    }
}