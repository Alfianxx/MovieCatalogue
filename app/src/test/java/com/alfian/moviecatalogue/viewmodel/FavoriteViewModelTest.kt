package com.alfian.moviecatalogue.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.alfian.moviecatalogue.data.MovieEntity
import com.alfian.moviecatalogue.data.TvShowEntity
import com.alfian.moviecatalogue.data.source.FilmRepository
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteViewModelTest {

    private lateinit var viewModel: FavoriteViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observerMovie: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var pagedListMovie: PagedList<MovieEntity>

    @Mock
    private lateinit var observerTv: Observer<PagedList<TvShowEntity>>

    @Mock
    private lateinit var pagedListTv: PagedList<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = FavoriteViewModel(filmRepository)
    }

    @Test
    fun getFavoriteMovie() {

        val dummyMovie = pagedListMovie
        Mockito.`when`(dummyMovie.size).thenReturn(19)
        val movie = MutableLiveData<PagedList<MovieEntity>>()

        movie.value = dummyMovie

        Mockito.`when`(filmRepository.getFavoriteMovie()).thenReturn(movie)
        val movieEntities = viewModel.getFavoriteMovie().value
        Mockito.verify(filmRepository).getFavoriteMovie()
        assertNotNull(movieEntities)
        assertEquals(19, movieEntities?.size)

        viewModel.getFavoriteMovie().observeForever(observerMovie)
        Mockito.verify(observerMovie).onChanged(dummyMovie)

    }

    @Test
    fun getFavoriteTv() {
        val dummyTv = pagedListTv
        Mockito.`when`(dummyTv.size).thenReturn(15)
        val tvShow = MutableLiveData<PagedList<TvShowEntity>>()

        tvShow.value = dummyTv

        Mockito.`when`(filmRepository.getFavoriteTv()).thenReturn(tvShow)
        val tvShowEntities = viewModel.getFavoriteTv().value
        Mockito.verify(filmRepository).getFavoriteTv()
        assertNotNull(tvShowEntities)
        assertEquals(15, tvShowEntities?.size)

        viewModel.getFavoriteTv().observeForever(observerTv)
        Mockito.verify(observerTv).onChanged(dummyTv)

    }
}