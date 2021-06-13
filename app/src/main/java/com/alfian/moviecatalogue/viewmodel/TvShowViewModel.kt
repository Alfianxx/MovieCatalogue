package com.alfian.moviecatalogue.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.alfian.moviecatalogue.data.TvShowEntity
import com.alfian.moviecatalogue.data.source.FilmRepository
import com.alfian.moviecatalogue.vo.Resource

class TvShowViewModel(private val filmRepository: FilmRepository) : ViewModel() {
    fun getTvShow(): LiveData<Resource<PagedList<TvShowEntity>>> = filmRepository.getAllTvShow()

    fun setFavoriteTv(tvShowEntity: TvShowEntity, newState: Boolean) {
        filmRepository.setFavoriteTv(tvShowEntity, newState)
    }
}