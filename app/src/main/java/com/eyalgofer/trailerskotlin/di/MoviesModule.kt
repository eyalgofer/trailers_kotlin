package com.eyalgofer.trailerskotlin.di

import com.eyalgofer.trailerskotlin.api.MoveisRestApi
import com.eyalgofer.trailerskotlin.api.MoviesApi
import com.eyalgofer.trailerskotlin.api.MoviesDBApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by eyalgofer on 10/08/2017.
 */
@Module
class MoviesModule {

    @Provides
    @Singleton
    fun provideMoviesApi(moviesDBApi: MoviesDBApi): MoviesApi = MoveisRestApi(moviesDBApi)

    @Provides
    @Singleton
    fun provideMoviesDBApi(retrofit: Retrofit): MoviesDBApi = retrofit.create(MoviesDBApi::class.java)
}