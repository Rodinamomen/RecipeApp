package com.example.recipeapp.database

import androidx.room.Entity

@Entity(primaryKeys = ["userEmail","idMeal"])
data class FavouriteList (
    val userEmail : String="",
    val idMeal :String=""
)