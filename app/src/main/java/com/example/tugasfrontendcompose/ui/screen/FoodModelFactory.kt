package com.example.tugasfrontendcompose.ui.screen

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tugasfrontendcompose.data.repo.FoodRepo
import com.example.tugasfrontendcompose.di.Injection
import com.example.tugasfrontendcompose.ui.screen.home.HomeViewModel
import com.example.tugasfrontendcompose.ui.screen.recomendation.LocalFoodViewModel
import com.example.tugasfrontendcompose.ui.screen.recomendation.RecomViewModel

class FoodModelFactory(private val repo: FoodRepo) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(repo) as T
            }
            modelClass.isAssignableFrom(LocalFoodViewModel::class.java) -> {
                LocalFoodViewModel(repo) as T
            }


            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: FoodModelFactory? = null
        @JvmStatic
        fun getInstance(context: Context): FoodModelFactory {
            return INSTANCE ?: synchronized(FoodModelFactory::class.java) {
                INSTANCE ?: FoodModelFactory(
                    Injection.provideRepository(context)
                ).also { INSTANCE = it }
            }
        }
    }
}