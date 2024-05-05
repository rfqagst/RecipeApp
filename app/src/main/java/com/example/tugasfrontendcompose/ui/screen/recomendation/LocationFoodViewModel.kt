package com.example.tugasfrontendcompose.ui.screen.recomendation

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tugasfrontendcompose.data.repo.FoodRepo
import com.example.tugasfrontendcompose.data.response.MealsItem
import com.example.tugasfrontendcompose.data.response.MealsItemLocation
import com.example.tugasfrontendcompose.util.Resource
import kotlinx.coroutines.launch

class LocationFoodViewModel(val foodRepo: FoodRepo) : ViewModel() {

    private val _location = mutableStateOf<List<MealsItemLocation?>?>(null)
    val location: State<List<MealsItemLocation?>?> = _location


    private val _locationFood = mutableStateOf<List<MealsItem?>?>(null)
    val locationFood: State<List<MealsItem?>?> = _locationFood

    var activeLocation by mutableStateOf<String?>(null)

    init {
        getLocation()
        getFoodByLocation("American")
    }

    fun getLocation() {
        viewModelScope.launch {
            val result = foodRepo.getLocation()
            if (result is Resource.Success) {
                _location.value = result.data?.meals
            } else {
                // Handle error case
            }
        }
    }

    fun getFoodByLocation(location: String) {
        activeLocation = location
        viewModelScope.launch {
            val result = foodRepo.getFoodByLocation(location)
            if (result is Resource.Success) {
                _locationFood.value = result.data?.meals
            } else {
                // Handle error case
            }
        }
    }

}