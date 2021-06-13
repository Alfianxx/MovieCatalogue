package com.alfian.moviecatalogue.ui.di

import android.content.Context
import com.alfian.moviecatalogue.data.source.FilmRepository
import com.alfian.moviecatalogue.data.source.local.LocalDataSource
import com.alfian.moviecatalogue.data.source.local.room.FilmDatabase
import com.alfian.moviecatalogue.data.source.remote.RemoteDataSource
import com.alfian.moviecatalogue.utils.AppExecutors
import com.alfian.moviecatalogue.utils.DataDummy

object Injection {
    fun provideRepository(context: Context): FilmRepository {

        val database = FilmDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(DataDummy)
        val localDataSource = LocalDataSource.getInstance(database.filmDao())
        val appExecutors = AppExecutors()

        return FilmRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}