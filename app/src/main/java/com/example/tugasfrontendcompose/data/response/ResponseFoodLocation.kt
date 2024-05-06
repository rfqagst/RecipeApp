package com.example.tugasfrontendcompose.data.response

import com.google.gson.annotations.SerializedName

data class ResponseFoodLocation(

    @field:SerializedName("meals")
    val meals: List<MealsItemLocation?>? = null
)

data class MealsItemLocation(

    @field:SerializedName("strArea")
    val strArea: String? = null
)
