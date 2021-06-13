package com.alfian.moviecatalogue.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.alfian.moviecatalogue.data.TvShowEntity
import com.alfian.moviecatalogue.data.source.FilmRepository
import com.alfian.moviecatalogue.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<TvShowEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(filmRepository)
    }

    @Test
    fun getTvShow() {

        val dummyTvShow = Resource.success(pagedList)
        `when`(dummyTvShow.data?.size).thenReturn(15)

        val tvShow = MutableLiveData<Resource<PagedList<TvShowEntity>>>()
        tvShow.value = dummyTvShow

        `when`(filmRepository.getAllTvShow()).thenReturn(tvShow)
        val tvShowEntity = viewModel.getTvShow().value?.data
        verify(filmRepository).getAllTvShow()
        assertNotNull(tvShowEntity)
        assertEquals(15, tvShowEntity?.size)

        viewModel.getTvShow().observeForever(observer)
        verify(observer).onChanged(dummyTvShow)

    }

}