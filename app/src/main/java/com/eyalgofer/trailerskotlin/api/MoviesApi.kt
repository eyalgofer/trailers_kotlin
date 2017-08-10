package com.eyalgofer.trailerskotlin.api

import retrofit2.Call

/**
 * Created by eyalgofer on 10/08/2017.
 */
interface MoviesApi {
    fun getMovies(page: Int): Call<MovieDataResponse>
}