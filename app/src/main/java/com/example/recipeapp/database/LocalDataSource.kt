package com.example.recipeapp.database

interface LocalDataSource {
    suspend fun insertUser(user: User)
    suspend fun getFavouriteMealsWithUserEmail(userEmail:String): UserWithMeals?
    suspend fun insertIntoFavourites(favouriteList: FavouriteList)
    suspend fun isFavourite(userEmail: String,idMeal:String): Boolean
    suspend fun removeMealsByMealId(idMeal: String)
}