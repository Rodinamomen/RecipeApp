package com.example.recipeapp.database

import android.content.Context

class LocalDataSourceImp(context: Context):LocalDataSource {
    private lateinit var userDao: UserDao
    private lateinit var userWithMealsDao: UserWithMealsDao
    private lateinit var mealDao: MealDao
    init {
        val db: ApplicationDataBase = ApplicationDataBase.getInstance(context)
        userDao = db.userDao()
        userWithMealsDao = db.userWithMealsDao()
        mealDao= db.mealDao()
    }
    override suspend fun insertUser(user: User) {
        userDao.insertUser(user)
    }

    override suspend fun getFavouriteMealsWithUserEmail(userEmail: String): UserWithMeals? {
        return userWithMealsDao.getUserWithMealsByEmail(userEmail)
    }


    override suspend fun insertIntoFavourites(favouriteList: FavouriteList) {
          userWithMealsDao.insert(favouriteList)
    }

    override suspend fun isFavourite(userEmail: String, idMeal: String): Boolean {
         return userWithMealsDao.isFavourite(userEmail,idMeal)
    }

    override suspend fun removeMealsByMealId(idMeal: String) {
         userWithMealsDao.removeMealsByMealId(idMeal)
    }
}