package com.example.tripcompanion.data.api

import com.example.tripcompanion.models.Trip
import retrofit2.http.GET
import retrofit2.http.POST

interface TripApi {
    @GET("/trips.json")
    suspend fun fetchTrips():List<Trip>
    @POST("")
    suspend fun addTrip()
}