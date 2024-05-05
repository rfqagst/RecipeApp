package com.example.tugasfrontendcompose.data.retrofit

import com.example.tugasfrontendcompose.data.response.ResponseCategory
import com.example.tugasfrontendcompose.data.response.ResponseCategoryFood
import com.example.tugasfrontendcompose.data.response.ResponseDetailFood
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("categories.php")
    suspend fun getCategory(): ResponseCategory

    @GET("filter.php")
    suspend fun getFoodByCategory(@Query("c") category: String): ResponseCategoryFood

    @GET("lookup.php")
    suspend fun getDetailFoodById(@Query("i") id: String): ResponseDetailFood

    @GET("random.php")
    suspend fun getFoodByRandom(): ResponseCategoryFood
}