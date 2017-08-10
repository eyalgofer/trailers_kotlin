package com.eyalgofer.trailerskotlin.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/**
 * Created by eyalgofer on 10/08/2017.
 */
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("http://api.themoviedb.org")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
    }
}