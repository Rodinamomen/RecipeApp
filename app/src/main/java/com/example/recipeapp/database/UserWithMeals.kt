package com.example.recipeapp.database

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Junction
import androidx.room.Relation
@Entity
data class UserWithMeals( @Embedded
                          val user: User,
                          @Relation(
                              parentColumn = "userEmail",
                              entityColumn = "idMeal",
                              associateBy = Junction(FavouriteList::class)
                          )
                          val meals : List<Meal>)
