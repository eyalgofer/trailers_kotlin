package com.eyalgofer.trailerskotlin.adapters

import android.graphics.Movie
import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.eyalgofer.trailerskotlin.commons.ViewType
import com.eyalgofer.trailerskotlin.models.MovieItem
import java.util.ArrayList

/**
 * Created by eyalgofer on 10/08/2017.
 */

class MoviesAdapter(listener: MoviesDelegateAdapter.onViewSelectedListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {



    private var items: ArrayList<ViewType>
    private var delegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()
    private val loadingItem = object : ViewType {
        override fun getViewType() = AdapterConstants.LOADING
    }

    init {
        delegateAdapters.put(AdapterConstants.LOADING, LoadingDelegateAdapter())
        delegateAdapters.put(AdapterConstants.MOVIE, MoviesDelegateAdapter(listener))
        items = ArrayList()
        items.add(loadingItem)
    }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            delegateAdapters.get(viewType).onCreateViewHolder(parent)


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegateAdapters.get(getItemViewType(position)).onBindViewHolder(holder, items[position])
    }

    override fun getItemViewType(position: Int) = items[position].getViewType()

    fun addMovies(news: List<MovieItem>) {
        // first remove loading and notify
        val initPosition = items.size - 1
        items.removeAt(initPosition)
        notifyItemRemoved(initPosition)

        // insert movies and the loading at the end of the list
        items.addAll(news)
        items.add(loadingItem)
        notifyItemRangeChanged(initPosition, items.size + 1 /* plus loading item */)
    }

    fun clearAndAddMovies(news: List<MovieItem>) {
        items.clear()
        notifyItemRangeRemoved(0, getLastPosition())

        items.addAll(news)
        items.add(loadingItem)
        notifyItemRangeInserted(0, items.size)
    }

    fun getMovies(): List<MovieItem> =
            items
                    .filter { it.getViewType() == AdapterConstants.MOVIE }
                    .map { it as MovieItem }

    private fun getLastPosition() = if (items.lastIndex == -1) 0 else items.lastIndex
}