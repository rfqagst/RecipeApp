package com.example.tugasfrontendcompose.ui.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tugasfrontendcompose.data.repo.FoodRepo
import com.example.tugasfrontendcompose.data.response.MealsItemDetail
import com.example.tugasfrontendcompose.util.Resource
import kotlinx.coroutines.launch

class SearchViewModel(val foodRepo: FoodRepo) : ViewModel() {

    private val _recipeName = mutableStateOf<List<MealsItemDetail?>?>(null)
    val recipeName: State<List<MealsItemDetail?>?> = _recipeName

    fun searchRecipeByName(recipeNameQuery : String) {
        viewModelScope.launch {
            val result = foodRepo.searchRecipeByName(recipeNameQuery)
            if (result is Resource.Success) {
                _recipeName.value = result.data?.meals

            } else {
                //
            }
        }
    }
}