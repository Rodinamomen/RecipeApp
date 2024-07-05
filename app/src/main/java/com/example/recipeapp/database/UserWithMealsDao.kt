package com.example.recipeapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface UserWithMealsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(favouriteList: FavouriteList)
    @Transaction
    @Query("DELETE FROM FavouriteList WHERE FavouriteList.idMeal = :idMeal")
    suspend fun removeMealsByMealId(idMeal: String)
    @Transaction
    @Query("SELECT * FROM USER")
    suspend fun getUserWithMeals(): List<UserWithMeals>

    @Transaction
    @Query("SELECT * FROM User WHERE userEmail = :userEmail")
    fun getUserWithMealsByEmail(userEmail: String): UserWithMeals?

    @Transaction
    @Query("SELECT EXISTS(SELECT * FROM FavouriteList WHERE userEmail = :userEmail AND idMeal =:idMeal )")
    suspend fun isFavourite(userEmail:String,idMeal:String): Boolean

}