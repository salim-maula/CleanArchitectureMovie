package com.salim.android.tmdbclient.presentation.di.core

import com.salim.android.tmdbclient.data.api.TMDBService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule(private val baseUrl : String) {

    //create retrofit instance
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

    //create TMDB Service
    @Singleton
    @Provides
    fun provideTMDBService(retrofit: Retrofit): TMDBService{
        return retrofit.create(TMDBService::class.java)
    }
}