package com.eyalgofer.trailerskotlin.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by eyalgofer on 10/08/2017.
 */
interface MoviesDBApi {
    @GET("/3/discover/movie?language=en&sort_by=popularity.desc&api_key=c1589a47353ffb19b5eaad628f860f5c")
    fun getMovies(@Query("page") page: String): Call<MovieDataResponse>
}