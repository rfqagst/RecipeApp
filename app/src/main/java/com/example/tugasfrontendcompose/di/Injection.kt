package com.example.tugasfrontendcompose.di

import android.content.Context
import com.example.tugasfrontendcompose.data.repo.FoodRepo
import com.example.tugasfrontendcompose.data.retrofit.ApiConfig

object Injection {
     fun provideRepository(context: Context): FoodRepo {
        val apiService = ApiConfig.getApiService()
        return FoodRepo.getInstance(apiService)
    }

}