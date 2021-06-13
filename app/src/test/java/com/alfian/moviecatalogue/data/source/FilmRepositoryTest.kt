package com.alfian.moviecatalogue.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.DataSource
import com.alfian.moviecatalogue.data.MovieEntity
import com.alfian.moviecatalogue.data.TvShowEntity
import com.alfian.moviecatalogue.data.source.local.LocalDataSource
import com.alfian.moviecatalogue.data.source.remote.RemoteDataSource
import com.alfian.moviecatalogue.utils.AppExecutors
import com.alfian.moviecatalogue.utils.DataDummy
import com.alfian.moviecatalogue.utils.PagedListUtil
import com.alfian.moviecatalogue.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class FilmRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)

    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val filmRepository = FakeFilmRepository(remote, local, appExecutors)

    private val movieResponses = DataDummy.generateDummyMovie()

    private val tvShowResponses = DataDummy.generateDummyTvShow()

    @Test
    fun getAllMovie() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMovie()).thenReturn(dataSourceFactory)
        filmRepository.getAllMovie()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovie()))
        verify(local).getAllMovie()
        Assert.assertNotNull(movieEntities.data)
        assertEquals(movieResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }


    @Test
    fun getAllTvShow() {

        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getAllTvShow()).thenReturn(dataSourceFactory)
        filmRepository.getAllTvShow()

        val tvShowEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvShow()))
        verify(local).getAllTvShow()
        Assert.assertNotNull(tvShowEntities.data)
        assertEquals(tvShowResponses.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun getFavoriteMovie() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getFavoriteMovie()).thenReturn(dataSourceFactory)
        filmRepository.getFavoriteMovie()
        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovie()))
        verify(local).getFavoriteMovie()
        Assert.assertNotNull(movieEntities)
        assertEquals(movieResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getFavoriteTv() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getFavoriteTv()).thenReturn(dataSourceFactory)
        filmRepository.getFavoriteTv()
        val tvShowEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvShow()))
        verify(local).getFavoriteTv()
        Assert.assertNotNull(tvShowEntities)
        assertEquals(tvShowResponses.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

}