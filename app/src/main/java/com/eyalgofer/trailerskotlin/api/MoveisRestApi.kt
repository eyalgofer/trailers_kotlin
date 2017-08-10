package com.eyalgofer.trailerskotlin.api

import retrofit2.Call
import javax.inject.Inject

/**
 * Created by eyalgofer on 10/08/2017.
 */
class MoveisRestApi @Inject constructor(private val moviesDBApi: MoviesDBApi) : MoviesApi {
    override fun getMovies(page: Int): Call<MovieDataResponse> {
        return moviesDBApi.getMovies(page.toString())
    }
}