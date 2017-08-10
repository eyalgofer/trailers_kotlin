package com.eyalgofer.trailerskotlin.di

import android.app.Application
import android.content.Context
import com.eyalgofer.trailerskotlin.TrailersApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by eyalgofer on 10/08/2017.
 */
@Module
class AppModule(val app: TrailersApp) {
    @Provides
    @Singleton
    fun provideContext(): Context = app

    @Provides
    @Singleton
    fun provideApplication(): Application = app
}