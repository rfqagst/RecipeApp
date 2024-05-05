package com.example.tugasfrontendcompose.ui.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tugasfrontendcompose.data.repo.FoodRepo
import com.example.tugasfrontendcompose.data.response.CategoriesItem
import com.example.tugasfrontendcompose.data.response.MealsItem
import com.example.tugasfrontendcompose.util.Resource
import kotlinx.coroutines.launch

class HomeViewModel(val foodRepo: FoodRepo) : ViewModel() {

    var activeCategory by mutableStateOf<String?>(null)

    private val _categories = mutableStateOf<List<CategoriesItem?>?>(null)
    val categories: State<List<CategoriesItem?>?> = _categories


    private val _categoriesFood = mutableStateOf<List<MealsItem?>?>(null)
    val categoriesFood: State<List<MealsItem?>?> = _categoriesFood


    init {
        getCategory()
        getFoodByCategory("Beef")
    }

     fun getCategory() {
        viewModelScope.launch {
            val result = foodRepo.getCategory()
            if (result is Resource.Success) {
                _categories.value = result.data?.categories
            } else {
                // Handle error case
            }
        }
    }

     fun getFoodByCategory(category : String) {
         activeCategory = category
        viewModelScope.launch {
            val result = foodRepo.getFoodByCategory(category)
            if (result is Resource.Success) {
                _categoriesFood.value = result.data?.meals
            } else {
                // Handle error case
            }
        }
    }
}