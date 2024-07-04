package com.example.recipeapp.home.repo

import com.example.recipeapp.home.model.Recipe
import com.example.recipeapp.network.RemoteDataSource

class HomeRepoImp(val remoteDataSource: RemoteDataSource) : HomeRepo{
    override suspend fun getAllMeals(randomChar: Char): Recipe {
        return remoteDataSource.getAllMeals(randomChar)
    }
}