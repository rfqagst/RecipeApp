package com.example.tugasfrontendcompose.ui.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tugasfrontendcompose.data.repo.FoodRepo
import com.example.tugasfrontendcompose.data.response.CategoriesItem
import com.example.tugasfrontendcompose.util.Resource
import kotlinx.coroutines.launch

class HomeViewModel(val foodRepo: FoodRepo) : ViewModel() {
    private val _categories = mutableStateOf<List<CategoriesItem?>?>(null)
    val categories: State<List<CategoriesItem?>?> = _categories

    init {
        getCategory()
    }

    private fun getCategory() {
        viewModelScope.launch {
            val result = foodRepo.getCategory()
            if (result is Resource.Success) {
                _categories.value = result.data?.categories
            } else {
                // Handle error case
            }
        }
    }
}