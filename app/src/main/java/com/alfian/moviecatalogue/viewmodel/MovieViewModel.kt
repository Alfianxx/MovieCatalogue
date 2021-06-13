package com.alfian.moviecatalogue.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.alfian.moviecatalogue.data.MovieEntity
import com.alfian.moviecatalogue.data.source.FilmRepository
import com.alfian.moviecatalogue.vo.Resource

class MovieViewModel(private val filmRepository: FilmRepository) : ViewModel() {

    fun getMovie(): LiveData<Resource<PagedList<MovieEntity>>> = filmRepository.getAllMovie()

    fun setFavoriteMovie(movieEntity: MovieEntity, newState: Boolean) {
        filmRepository.setFavoriteMovie(movieEntity, newState)
    }

}