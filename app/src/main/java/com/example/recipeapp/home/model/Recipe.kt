package com.example.recipeapp.home.model

import androidx.room.Entity
import com.example.recipeapp.database.Meal

@Entity
data class Recipe(
    val meals: List<Meal>
)