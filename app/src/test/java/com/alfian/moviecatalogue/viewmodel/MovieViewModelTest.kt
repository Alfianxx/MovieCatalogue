package com.alfian.moviecatalogue.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.alfian.moviecatalogue.data.MovieEntity
import com.alfian.moviecatalogue.data.source.FilmRepository
import com.alfian.moviecatalogue.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<MovieEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<MovieEntity>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(filmRepository)
    }

    @Test
    fun getMovie() {

        val dummyMovie = Resource.success(pagedList)
        `when`(dummyMovie.data?.size).thenReturn(19)
        val movie = MutableLiveData<Resource<PagedList<MovieEntity>>>()
        movie.value = dummyMovie

        `when`(filmRepository.getAllMovie()).thenReturn(movie)
        val movieEntity = viewModel.getMovie().value?.data
        verify(filmRepository).getAllMovie()
        assertNotNull(movieEntity)
        assertEquals(19, movieEntity?.size)

        viewModel.getMovie().observeForever(observer)
        verify(observer).onChanged(dummyMovie)

    }

}