package com.example.recipeapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface MealDao {
    @Insert
    suspend fun insertMeal(meal: Meal)
  @Transaction
    @Query("SELECT * FROM meal WHERE idMeal = :idMeal")
    suspend fun getMealById(idMeal: String): Meal?
}