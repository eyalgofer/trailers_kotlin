package com.eyalgofer.trailerskotlin

import com.eyalgofer.trailerskotlin.api.MoviesApi
import com.eyalgofer.trailerskotlin.models.DBMovies
import com.eyalgofer.trailerskotlin.models.MovieItem
import rx.Observable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by eyalgofer on 10/08/2017.
 */
@Singleton
class MoviesManager @Inject constructor(private val api: MoviesApi) {

    fun getMovies(page: Int): Observable<DBMovies> {
        return Observable.create {
            subscriber ->
            val callResponse = api.getMovies(page)
            val response = callResponse.execute()

            if (response.isSuccessful) {
                val dataResponse = response.body()
                val movies = dataResponse.results.map {
                    MovieItem(it.title,it.vote_average,it.vote_count,it.overview,it.release_date,it.poster_path)
                }
                val dbMovies = DBMovies(
                        movies,
                        dataResponse.page,
                        dataResponse.total_pages
                        )
                subscriber.onNext(dbMovies)
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }
}