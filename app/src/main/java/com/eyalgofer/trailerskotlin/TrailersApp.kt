package com.eyalgofer.trailerskotlin

import android.app.Application
import com.eyalgofer.trailerskotlin.di.AppModule
import com.eyalgofer.trailerskotlin.di.DaggerMoviesComponent
import com.eyalgofer.trailerskotlin.di.MoviesComponent

/**
 * Created by eyalgofer on 10/08/2017.
 */
class TrailersApp : Application() {

    companion object {
        lateinit var moviesComponent: MoviesComponent
        val MOVIE_DB_KEY = "c1589a47353ffb19b5eaad628f860f5c"
        val POSTER_PATH = "http://image.tmdb.org/t/p/w185"
    }

    override fun onCreate() {
        super.onCreate()
        moviesComponent = DaggerMoviesComponent.builder()
                .appModule(AppModule(this))
                .build()
    }
}