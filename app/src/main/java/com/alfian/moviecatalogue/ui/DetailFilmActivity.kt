package com.alfian.moviecatalogue.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.alfian.moviecatalogue.R
import com.alfian.moviecatalogue.data.MovieEntity
import com.alfian.moviecatalogue.data.TvShowEntity
import com.alfian.moviecatalogue.databinding.ActivityDetailFilmBinding
import com.alfian.moviecatalogue.viewmodel.MovieViewModel
import com.alfian.moviecatalogue.viewmodel.TvShowViewModel
import com.alfian.moviecatalogue.viewmodel.ViewModelFactory
import com.alfian.moviecatalogue.vo.Status
import com.bumptech.glide.Glide

class DetailFilmActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_film"
        const val EXTRA_TV_SHOW = "extra_tv_show"
        const val EXTRA_CHECK = "extra_check"
    }

    private lateinit var detailFilmBinding: ActivityDetailFilmBinding

    private var movieEntity: MovieEntity? = null

    private var tvShowEntity: TvShowEntity? = null

    private var movieViewModel: MovieViewModel? = null

    private var tvShowViewModel: TvShowViewModel? = null

    private var menu: Menu? = null

    private var movieId: String? = null
    private var tvShowId: String? = null

    private var isFromMovie = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailFilmBinding = ActivityDetailFilmBinding.inflate(layoutInflater)
        setContentView(detailFilmBinding.root)

        supportActionBar?.title = "Detail Film"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)

        detailFilmBinding.progressBar.progressView.bringToFront()

        detailFilmBinding.progressBar.progressView.visibility = View.VISIBLE


        val extras = intent.extras
        if (extras != null) {
            isFromMovie = extras.getBoolean(EXTRA_CHECK, false)
            if (isFromMovie) {

                movieViewModel = ViewModelProvider(
                    this,
                    factory
                )[MovieViewModel::class.java]

                movieId = extras.getString(EXTRA_MOVIE)
                if (movieId != null) {

                    movieViewModel?.getMovie()?.observe(this, { movie ->

                        if (movie != null) {
                            when (movie.status) {
                                Status.LOADING -> {
                                    detailFilmBinding.progressBar.progressView.visibility =
                                        View.VISIBLE

                                }
                                Status.SUCCESS -> {
                                    movie.data?.let { movies ->
                                        for (m in movies) {
                                            if (m.movieId == movieId) {
                                                setDetailMovie(m)
                                                movieEntity = m
                                                detailFilmBinding.progressBar.progressView.visibility =
                                                    View.GONE

                                            }
                                        }
                                    }
                                }
                                Status.ERROR -> {
                                    detailFilmBinding.progressBar.progressView.visibility =
                                        View.GONE
                                    Toast.makeText(this, "Something wrong", Toast.LENGTH_SHORT)
                                        .show()
                                }
                            }
                        }
                    })

                }

            } else {

                tvShowViewModel = ViewModelProvider(
                    this,
                    factory
                )[TvShowViewModel::class.java]

                tvShowId = extras.getString(EXTRA_TV_SHOW)
                if (tvShowId != null) {

                    tvShowViewModel?.getTvShow()?.observe(this, { tvShow ->

                        if (tvShow != null) {
                            when (tvShow.status) {
                                Status.LOADING -> detailFilmBinding.progressBar.progressView.visibility =
                                    View.VISIBLE
                                Status.SUCCESS -> {
                                    tvShow.data?.let { tvShows ->
                                        for (tv in tvShows) {
                                            if (tv.tvShowId == tvShowId) {
                                                setDetailTvShow(tv)
                                                tvShowEntity = tv
                                                detailFilmBinding.progressBar.progressView.visibility =
                                                    View.GONE
                                            }
                                        }
                                    }
                                }
                                Status.ERROR -> {
                                    detailFilmBinding.progressBar.progressView.visibility =
                                        View.GONE
                                    Toast.makeText(this, "Something wrong", Toast.LENGTH_SHORT)
                                        .show()
                                }
                            }
                        }
                    })
                }
            }

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.favorite_menu, menu)

        this.menu = menu

        if (isFromMovie) {

            movieViewModel?.getMovie()?.observe(this, { movie ->

                if (movie != null) {
                    when (movie.status) {
                        Status.LOADING -> detailFilmBinding.progressBar.progressView.visibility =
                            View.VISIBLE
                        Status.SUCCESS -> {
                            movie.data?.let { movies ->
                                for (m in movies) {
                                    if (m.movieId == movieId) {
                                        setBookmarkState(m.movieFavorite)
                                        detailFilmBinding.progressBar.progressView.visibility =
                                            View.GONE
                                    }
                                }
                            }
                        }
                        Status.ERROR -> {
                            detailFilmBinding.progressBar.progressView.visibility =
                                View.GONE
                            Toast.makeText(this, "Something wrong", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }
            })
            return true

        } else {
            tvShowViewModel?.getTvShow()?.observe(this, { tvShow ->

                if (tvShow != null) {
                    when (tvShow.status) {
                        Status.LOADING -> detailFilmBinding.progressBar.progressView.visibility =
                            View.VISIBLE
                        Status.SUCCESS -> {
                            tvShow.data?.let { tvShows ->
                                for (tv in tvShows) {
                                    if (tv.tvShowId == tvShowId) {
                                        setBookmarkState(tv.tvFavorite)
                                        detailFilmBinding.progressBar.progressView.visibility =
                                            View.GONE
                                    }
                                }
                            }
                        }
                        Status.ERROR -> {
                            detailFilmBinding.progressBar.progressView.visibility =
                                View.GONE
                            Toast.makeText(this, "Something wrong", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }

                }
            })
            return true
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.favorite_film -> {

                return if (isFromMovie) {
                    movieEntity?.let { movie ->
                        val newState = !movie.movieFavorite
                        movieViewModel?.setFavoriteMovie(movie, newState)
                    }
                    true
                } else {
                    tvShowEntity?.let { tvShow ->
                        val newState = !tvShow.tvFavorite
                        tvShowViewModel?.setFavoriteTv(tvShow, newState)

                    }
                    true
                }
            }
            android.R.id.home -> {
                finish()
                return true
            }


        }


        return super.onOptionsItemSelected(item)
    }

    private fun setBookmarkState(state: Boolean) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.favorite_film)
        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite_film)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_unfavorite_film)
        }
    }

    private fun setDetailTvShow(tvShow: TvShowEntity) {

        detailFilmBinding.apply {
            tvTitle.text = tvShow.title
            description.text = tvShow.description
            duration.text = tvShow.duration
            rating.text = tvShow.rating.toString()
            genre.text = tvShow.genre
        }

        Glide.with(this)
            .load(tvShow.poster)
            .into(detailFilmBinding.imgPoster)
    }

    private fun setDetailMovie(movie: MovieEntity) {

        detailFilmBinding.apply {
            tvTitle.text = movie.title
            description.text = movie.description
            duration.text = movie.duration
            rating.text = movie.rating.toString()
            genre.text = movie.genre
        }

        Glide.with(this)
            .load(movie.poster)
            .into(detailFilmBinding.imgPoster)
    }

}