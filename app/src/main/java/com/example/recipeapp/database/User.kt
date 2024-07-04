package com.example.recipeapp.database

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey
    var userEmail:String,
    @Ignore
    var password:String,
    )
