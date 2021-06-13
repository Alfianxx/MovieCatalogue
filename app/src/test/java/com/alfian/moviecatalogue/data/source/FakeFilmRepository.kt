package com.alfian.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.alfian.moviecatalogue.data.MovieEntity
import com.alfian.moviecatalogue.data.TvShowEntity
import com.alfian.moviecatalogue.data.source.local.LocalDataSource
import com.alfian.moviecatalogue.data.source.remote.ApiResponse
import com.alfian.moviecatalogue.data.source.remote.RemoteDataSource
import com.alfian.moviecatalogue.utils.AppExecutors
import com.alfian.moviecatalogue.vo.Resource

class FakeFilmRepository(
    private val remoteDataSource: RemoteDataSource, private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) :
    FilmDataSource {

    override fun getAllMovie(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object :
            NetworkBoundResource<PagedList<MovieEntity>, List<MovieEntity>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {

                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setPageSize(7)
                    .build()

                return LivePagedListBuilder(localDataSource.getAllMovie(), config).build()

            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<MovieEntity>>> =
                remoteDataSource.getAllMovies()

            public override fun saveCallResult(data: List<MovieEntity>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in data) {
                    val movie = MovieEntity(
                        response.movieId,
                        response.title,
                        response.description,
                        response.duration,
                        response.rating,
                        response.genre,
                        response.poster
                    )
                    movieList.add(movie)
                }
                localDataSource.insertMovie(movieList)
            }
        }.asLiveData()
    }

    override fun getAllTvShow(): LiveData<Resource<PagedList<TvShowEntity>>> {

        return object :
            NetworkBoundResource<PagedList<TvShowEntity>, List<TvShowEntity>>(appExecutors) {

            public override fun loadFromDB(): LiveData<PagedList<TvShowEntity>> {

                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setPageSize(6)
                    .build()

                return LivePagedListBuilder(localDataSource.getAllTvShow(), config).build()

            }

            override fun shouldFetch(data: PagedList<TvShowEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<TvShowEntity>>> =
                remoteDataSource.getAllTvShows()

            public override fun saveCallResult(data: List<TvShowEntity>) {
                val tvShowList = ArrayList<TvShowEntity>()
                for (response in data) {
                    val tvShow = TvShowEntity(
                        response.tvShowId,
                        response.title,
                        response.description,
                        response.duration,
                        response.rating,
                        response.genre,
                        response.poster
                    )
                    tvShowList.add(tvShow)
                }
                localDataSource.insertTvShow(tvShowList)
            }
        }.asLiveData()
    }

    override fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteMovie(), config).build()
    }

    override fun setFavoriteMovie(movie: MovieEntity, state: Boolean) {
        appExecutors.diskIO().execute { localDataSource.setMovieFavorite(movie, state) }
    }

    override fun getFavoriteTv(): LiveData<PagedList<TvShowEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteTv(), config).build()
    }

    override fun setFavoriteTv(tvShow: TvShowEntity, state: Boolean) {
        appExecutors.diskIO().execute { localDataSource.setTvFavorite(tvShow, state) }
    }


}