package com.example.tripcompanion.di

import androidx.compose.ui.unit.Constraints
import com.example.tripcompanion.data.api.TripApi
import com.example.tripcompanion.data.api.UserApi
import com.example.tripcompanion.util.Constants.TRIP_API_URL
import com.example.tripcompanion.util.Constants.USER_API_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
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

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient().newBuilder()
            .addInterceptor(interceptor)
            .build()
    }
    @Provides
    @Singleton
    fun provideUserApi(okHttpClient: OkHttpClient):UserApi{
        return Retrofit.Builder()
            .baseUrl(USER_API_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserApi::class.java)
    }

}