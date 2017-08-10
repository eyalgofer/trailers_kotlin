package com.eyalgofer.trailerskotlin.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.eyalgofer.trailerskotlin.commons.ViewType

/**
 * Created by eyalgofer on 10/08/2017.
 */
interface ViewTypeDelegateAdapter {
    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder

    fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType)
}