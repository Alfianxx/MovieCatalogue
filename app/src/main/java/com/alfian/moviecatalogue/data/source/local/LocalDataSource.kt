package com.alfian.moviecatalogue.data.source.local

import androidx.paging.DataSource
import com.alfian.moviecatalogue.data.MovieEntity
import com.alfian.moviecatalogue.data.TvShowEntity
import com.alfian.moviecatalogue.data.source.local.room.FilmDao

class LocalDataSource private constructor(private val mFilmDao: FilmDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(filmDao: FilmDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(filmDao)
    }

    fun getAllMovie(): DataSource.Factory<Int, MovieEntity> = mFilmDao.getMovie()

    fun getAllTvShow(): DataSource.Factory<Int, TvShowEntity> = mFilmDao.getTvShow()

    fun getFavoriteMovie(): DataSource.Factory<Int, MovieEntity> = mFilmDao.getFavoriteMovie()
    fun setMovieFavorite(movie: MovieEntity, newState: Boolean) {
        movie.movieFavorite = newState
        mFilmDao.updateMovie(movie)
    }

    fun getFavoriteTv(): DataSource.Factory<Int, TvShowEntity> = mFilmDao.getFavoriteTv()
    fun setTvFavorite(tvShow: TvShowEntity, newState: Boolean) {
        tvShow.tvFavorite = newState
        mFilmDao.updateTvShow(tvShow)
    }

    fun insertMovie(movie: List<MovieEntity>) = mFilmDao.insertMovie(movie)

    fun insertTvShow(tvShow: List<TvShowEntity>) = mFilmDao.insertTvShow(tvShow)

}