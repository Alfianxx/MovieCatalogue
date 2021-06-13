package com.alfian.moviecatalogue.data.source.remote

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alfian.moviecatalogue.data.MovieEntity
import com.alfian.moviecatalogue.data.TvShowEntity
import com.alfian.moviecatalogue.utils.DataDummy
import com.alfian.moviecatalogue.utils.EspressoIdlingResource


class RemoteDataSource private constructor(private val dummy: DataDummy) {

    private val handler = Handler(Looper.getMainLooper())

    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(dummy: DataDummy): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(dummy).apply {
                    instance = this
                }
            }
    }

    fun getAllMovies() : LiveData<ApiResponse<List<MovieEntity>>> {
        EspressoIdlingResource.increment()
        val resultMovie = MutableLiveData<ApiResponse<List<MovieEntity>>>()
        handler.postDelayed({
            resultMovie.value = ApiResponse.success(dummy.generateDummyMovie())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)

        return resultMovie
    }

    fun getAllTvShows() : LiveData<ApiResponse<List<TvShowEntity>>> {
        EspressoIdlingResource.increment()
        val resultTvShow = MutableLiveData<ApiResponse<List<TvShowEntity>>>()
        handler.postDelayed({
            resultTvShow.value = ApiResponse.success(dummy.generateDummyTvShow())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
        return resultTvShow
    }

}