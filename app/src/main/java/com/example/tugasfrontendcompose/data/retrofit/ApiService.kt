package com.example.tugasfrontendcompose.data.retrofit

import com.example.tugasfrontendcompose.data.response.ResponseCategory
import com.example.tugasfrontendcompose.data.response.ResponseCategoryFood
import com.example.tugasfrontendcompose.data.response.ResponseDetailFood
import com.example.tugasfrontendcompose.data.response.ResponseFoodLocation
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("categories.php")
    suspend fun getCategory(): ResponseCategory

    @GET("list.php?a=list")
    suspend fun getLocation(): ResponseFoodLocation

    @GET("filter.php")
    suspend fun getFoodByCategory(@Query("c") category: String): ResponseCategoryFood

    @GET("filter.php")
    suspend fun getFoodByLocation(@Query("a") category: String): ResponseCategoryFood

    @GET("lookup.php")
    suspend fun getDetailFoodById(@Query("i") id: String): ResponseDetailFood

}