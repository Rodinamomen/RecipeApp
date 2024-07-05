package com.example.recipeapp.home.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipeapp.database.FavouriteList
import com.example.recipeapp.database.Meal
import com.example.recipeapp.home.repo.HomeRepo
import kotlinx.coroutines.launch

class HomeViewModel(val homeRepo: HomeRepo):ViewModel() {
    private val _mealList = MutableLiveData<List<Meal>>()
    val mealList: LiveData<List<Meal>> = _mealList
    private val _isFavourite =MutableLiveData<Boolean>()
    val isFavourite: LiveData<Boolean> = _isFavourite
    fun getMealsList(randomChar: Char){
        viewModelScope.launch {
            val response = homeRepo.getAllMeals(randomChar)
            Log.d("respo", "getMealsList:${response} ")
            _mealList.value =response.meals
        }
    }
     fun insertIntoFavourites(favouriteList: FavouriteList){
         viewModelScope.launch {
              homeRepo.insertIntoFavourites(favouriteList)
         }
     }
     fun isFavourite(userEmail: String,idMeal:String){
        viewModelScope.launch {
          val result=  homeRepo.isFavourite(userEmail,idMeal)
            _isFavourite.value=result
        }
    }
    fun toggleFavorite(userEmail: String, idMeal: String) {
        viewModelScope.launch {
            if (isFavourite.value == true) {
               homeRepo.removeMealsByMealId(idMeal)
            } else {
                homeRepo.insertIntoFavourites(FavouriteList(userEmail, idMeal))
            }
            _isFavourite.value = homeRepo.isFavourite(userEmail, idMeal)
        }
    }
    fun removeMealsByMealId(idMeal: String){
        viewModelScope.launch {
            homeRepo.removeMealsByMealId(idMeal)
        }
    }
}