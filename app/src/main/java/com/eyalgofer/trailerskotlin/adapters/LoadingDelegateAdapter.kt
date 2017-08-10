package com.eyalgofer.trailerskotlin.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.eyalgofer.trailerskotlin.R
import com.eyalgofer.trailerskotlin.commons.ViewType
import com.eyalgofer.trailerskotlin.inflate

/**
 * Created by eyalgofer on 10/08/2017.
 */
class LoadingDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup) = LoadingViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
    }

    class LoadingViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.movie_item_loading)) {
    }
}