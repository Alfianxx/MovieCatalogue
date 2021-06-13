package com.alfian.moviecatalogue.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.alfian.moviecatalogue.data.MovieEntity
import com.alfian.moviecatalogue.data.TvShowEntity
import com.alfian.moviecatalogue.data.source.FilmRepository

class FavoriteViewModel(private val filmRepository: FilmRepository) : ViewModel() {

    fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>> = filmRepository.getFavoriteMovie()

    fun getFavoriteTv(): LiveData<PagedList<TvShowEntity>> = filmRepository.getFavoriteTv()

}