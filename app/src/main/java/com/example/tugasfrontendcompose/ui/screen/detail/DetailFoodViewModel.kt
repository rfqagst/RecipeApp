package com.example.tugasfrontendcompose.ui.screen.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tugasfrontendcompose.data.repo.FoodRepo
import com.example.tugasfrontendcompose.data.response.MealsItemDetail
import com.example.tugasfrontendcompose.util.Resource
import kotlinx.coroutines.launch

class DetailFoodViewModel(private val foodRepo: FoodRepo, private val foodId : String) : ViewModel() {
    private val _detailFood = mutableStateOf<List<MealsItemDetail?>?>(null)
    val detailFood: State<List<MealsItemDetail?>?> = _detailFood



    init {
        getDetailFoodById(foodId)
    }

    fun getDetailFoodById(id: String) {
        viewModelScope.launch {
            val result = foodRepo.getDetailFoodById(id)

            if (result is Resource.Success) {
                _detailFood.value = result.data?.meals

            } else {
                //
            }
        }
    }

}