package com.example.recipeapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class,Meal::class,FavouriteList::class], version = 4)
abstract class ApplicationDataBase:RoomDatabase() {
    abstract fun mealDao(): MealDao
    abstract fun userWithMealsDao(): UserWithMealsDao
    abstract fun userDao():UserDao
    companion object{
        @Volatile
        private var INSTANCE:ApplicationDataBase?= null
        fun getInstance(context: Context):ApplicationDataBase{
            return INSTANCE?: synchronized(this){
                INSTANCE?: Room.databaseBuilder(
                    context.applicationContext,
                    ApplicationDataBase::class.java,
                    "ApplicationDataBase"
                )   .fallbackToDestructiveMigration()
                    .build()
                    .also {
                        INSTANCE= it
                    }
            }
        }
    }
}