package com.example.recipeapp.home.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipeapp.database.Meal
import com.example.recipeapp.home.repo.HomeRepo
import kotlinx.coroutines.launch

class HomeViewModel(val homeRepo: HomeRepo):ViewModel() {
    private val _mealList = MutableLiveData<List<Meal>>()
    val mealList: LiveData<List<Meal>> = _mealList
    fun getMealsList(randomChar: Char){
        viewModelScope.launch {
            val response = homeRepo.getAllMeals(randomChar)
            Log.d("respo", "getMealsList:${response} ")
            _mealList.value =response.meals
        }
    }
}