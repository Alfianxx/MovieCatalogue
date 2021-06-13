package com.alfian.moviecatalogue.data.source.local.room

import androidx.paging.DataSource
import androidx.room.*
import com.alfian.moviecatalogue.data.MovieEntity
import com.alfian.moviecatalogue.data.TvShowEntity

@Dao
interface FilmDao {

    @Query("SELECT * FROM movieentity")
    fun getMovie(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM tvshowentity")
    fun getTvShow(): DataSource.Factory<Int, TvShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShow(tvShow: List<TvShowEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)

    @Update
    fun updateTvShow(tvShow: TvShowEntity)

    @Query("SELECT * FROM movieentity where movieFavorite = 1")
    fun getFavoriteMovie(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM tvshowentity where tvFavorite = 1")
    fun getFavoriteTv(): DataSource.Factory<Int, TvShowEntity>

}