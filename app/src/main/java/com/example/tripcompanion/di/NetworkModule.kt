package com.example.tripcompanion.di

import androidx.compose.ui.unit.Constraints
import com.example.tripcompanion.data.api.TripApi
import com.example.tripcompanion.util.Constants.TRIP_API_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideTripApi():TripApi{
        return Retrofit.Builder()
            .baseUrl(TRIP_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TripApi::class.java)
    }

}