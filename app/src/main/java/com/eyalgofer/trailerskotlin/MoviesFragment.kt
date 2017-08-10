package com.eyalgofer.trailerskotlin

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eyalgofer.trailerskotlin.adapters.MoviesAdapter
import com.eyalgofer.trailerskotlin.adapters.MoviesDelegateAdapter
import com.eyalgofer.trailerskotlin.models.DBMovies
import kotlinx.android.synthetic.main.movies_fragment.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by eyalgofer on 10/08/2017.
 */
class MoviesFragment : RxBaseFragment(), MoviesDelegateAdapter.onViewSelectedListener  {

    override fun onItemSelected(url: String?) {
    }

    @Inject lateinit var moviesManager: MoviesManager
    private var dbMovies: DBMovies? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //TODO: why?
        TrailersApp.moviesComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.movies_fragment)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        movies_list.apply {
            setHasFixedSize(true)
            val linearLayout = LinearLayoutManager(context)
            layoutManager = linearLayout
            clearOnScrollListeners()
            addOnScrollListener(InfiniteScrollListener({ requestMovies() }, linearLayout))
        }


        initAdapter()

        requestMovies()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
    }

    private fun requestMovies() {
        /**
         * first time will send empty string for 'after' parameter.
         * Next time we will have redditNews set with the next page to
         * navigate with the 'after' param.
         */
        val subscription = moviesManager.getMovies(dbMovies?.page ?: 1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe (
                        { retrievedMovies ->
                            dbMovies = retrievedMovies.apply{
                                page++
                            }
                            (movies_list.adapter as MoviesAdapter).addMovies(retrievedMovies.results)
                        },
                        { e ->
                            Log.d("MoviesFagment",e.toString())
                        }
                )
        subscriptions.add(subscription)
    }

    private fun initAdapter() {
        if (movies_list.adapter == null) {
            movies_list.adapter = MoviesAdapter(this)
        }
    }
}