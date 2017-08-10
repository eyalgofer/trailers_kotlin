package com.eyalgofer.trailerskotlin.models

/**
 * Created by eyalgofer on 10/08/2017.
 */
data class DBMovies  (
        val results: List<MovieItem>,
        var page: Int,
        val total_pages: Int)