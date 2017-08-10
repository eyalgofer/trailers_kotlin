package com.eyalgofer.trailerskotlin.di

import com.eyalgofer.trailerskotlin.MoviesFragment
import dagger.Component
import javax.inject.Singleton

/**
 * Created by eyalgofer on 10/08/2017.
 */
@Singleton
@Component(modules = arrayOf(
        AppModule::class,
        MoviesModule::class,
        NetworkModule::class)
)
interface MoviesComponent {

    fun inject(newsFragment: MoviesFragment)

}