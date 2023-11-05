package com.example.tripcompanion.data.api

import com.example.tripcompanion.models.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UserApi {
    @POST("users.json")
    suspend fun addUser(
       @Body user: User
    )

    @GET("users.json")
    suspend fun logIn():Map<String,User>
}