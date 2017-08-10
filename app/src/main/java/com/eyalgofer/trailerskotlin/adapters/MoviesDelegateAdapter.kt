package com.eyalgofer.trailerskotlin.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.eyalgofer.trailerskotlin.R
import com.eyalgofer.trailerskotlin.TrailersApp
import com.eyalgofer.trailerskotlin.commons.ViewType
import com.eyalgofer.trailerskotlin.inflate
import com.eyalgofer.trailerskotlin.loadImg
import com.eyalgofer.trailerskotlin.models.MovieItem
import kotlinx.android.synthetic.main.movie_item.view.*

/**
 * Created by eyalgofer on 10/08/2017.
 */
class MoviesDelegateAdapter(val viewActions: onViewSelectedListener) : ViewTypeDelegateAdapter {

    interface onViewSelectedListener {
        fun onItemSelected(url: String?)
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return MovieViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as MovieViewHolder
        holder.bind(item as MovieItem)
    }

    inner class MovieViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.movie_item)) {

        fun bind(item: MovieItem) = with(itemView) {
            img_thumbnail.loadImg(TrailersApp.POSTER_PATH + item.poster_path)
            title.text = item.title
            overview.text = item.overview
            vote_avg.text = item.vote_average.toString()
            vote_count.text = "(${item.vote_count})"
            release_date.text = item.release_date
            super.itemView.setOnClickListener { viewActions.onItemSelected("")}
        }
    }
}