package com.eyalgofer.trailerskotlin.api

/**
 * Created by eyalgofer on 10/08/2017.
 */
class MovieDataResponse(
        val results: List<MovieChildrenResponse>,
        val page: Int,
        val total_pages: Int
)

class MovieChildrenResponse(
        val title: String,
        val vote_average: Double,
        val vote_count: Int,
        val overview: String,
        val release_date: String,
        val poster_path: String
)