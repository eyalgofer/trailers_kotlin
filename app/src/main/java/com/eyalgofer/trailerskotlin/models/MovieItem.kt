package com.eyalgofer.trailerskotlin.models

import com.eyalgofer.trailerskotlin.adapters.AdapterConstants
import com.eyalgofer.trailerskotlin.commons.ViewType

/**
 * Created by eyalgofer on 10/08/2017.
 */
data class MovieItem(
        val title: String,
        val vote_average: Double,
        val vote_count: Int,
        val overview: String,
        val release_date: String,
        val poster_path: String
) : ViewType{
    override fun getViewType() = AdapterConstants.MOVIE
}