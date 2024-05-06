package com.example.tugasfrontendcompose.data.repo

import com.example.tugasfrontendcompose.data.response.ResponseCategory
import com.example.tugasfrontendcompose.data.response.ResponseCategoryFood
import com.example.tugasfrontendcompose.data.response.ResponseDetailFood
import com.example.tugasfrontendcompose.data.response.ResponseFoodLocation
import com.example.tugasfrontendcompose.data.retrofit.ApiService
import com.example.tugasfrontendcompose.util.Resource
import retrofit2.http.Query

class FoodRepo(
    private val apiService: ApiService
) {
    suspend fun getCategory(): Resource<ResponseCategory> {
        val response = try {
            apiService.getCategory()
        } catch (e: Exception) {
            return Resource.Error("Error unknown")
        }
        return Resource.Success(response)
    }

    suspend fun getFoodByCategory(@Query("c") category: String): Resource<ResponseCategoryFood> {
        val response = try {
            apiService.getFoodByCategory(category)
        } catch (e: Exception) {
            return Resource.Error("Error unknown")
        }
        return Resource.Success(response)

    }

    suspend fun getLocation(): Resource<ResponseFoodLocation> {
        val response = try {
            apiService.getLocation()
        } catch (e: Exception) {
            return Resource.Error("Error unknown")
        }
        return Resource.Success(response)
    }

    suspend fun getFoodByLocation(@Query("c") location: String): Resource<ResponseCategoryFood> {
        val response = try {
            apiService.getFoodByLocation(location)
        } catch (e: Exception) {
            return Resource.Error("Error unknown")
        }
        return Resource.Success(response)

    }

    suspend fun getDetailFoodById(@Query("i") id: String): Resource<ResponseDetailFood> {

        val response = try {
            apiService.getDetailFoodById(id)
        } catch (e: Exception) {
            return Resource.Error("Error unknown")
        }
        return Resource.Success(response)

    }

    suspend fun searchRecipeByName(@Query("s") recipeName: String): Resource<ResponseDetailFood> {

        val response = try {
            apiService.searchRecipeByName(recipeName)
        } catch (e: Exception) {
            return Resource.Error("Error unknown")
        }
        return Resource.Success(response)

    }


    companion object {
        @Volatile
        private var instance: FoodRepo? = null
        fun getInstance(
            apiService: ApiService
        ): FoodRepo =
            instance ?: synchronized(this) {
                instance ?: FoodRepo(apiService)
            }.also { instance = it }
    }


}