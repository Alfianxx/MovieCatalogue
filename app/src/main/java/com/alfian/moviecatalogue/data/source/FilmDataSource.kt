package com.alfian.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.alfian.moviecatalogue.data.MovieEntity
import com.alfian.moviecatalogue.data.TvShowEntity
import com.alfian.moviecatalogue.vo.Resource

interface FilmDataSource {

    fun getAllMovie(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getAllTvShow(): LiveData<Resource<PagedList<TvShowEntity>>>

    fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>>

    fun setFavoriteMovie(movie: MovieEntity, state: Boolean)

    fun getFavoriteTv(): LiveData<PagedList<TvShowEntity>>

    fun setFavoriteTv(tvShow: TvShowEntity, state: Boolean)

}