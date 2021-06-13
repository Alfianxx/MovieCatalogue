package com.alfian.moviecatalogue.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alfian.moviecatalogue.adapter.MovieAdapter
import com.alfian.moviecatalogue.databinding.FragmentFavoriteMoviesBinding
import com.alfian.moviecatalogue.viewmodel.FavoriteViewModel
import com.alfian.moviecatalogue.viewmodel.ViewModelFactory


class FavoriteMoviesFragment : Fragment() {

    private lateinit var fragmentFavoriteMoviesBinding: FragmentFavoriteMoviesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentFavoriteMoviesBinding = FragmentFavoriteMoviesBinding.inflate(layoutInflater, container, false)
        return fragmentFavoriteMoviesBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())

            val viewModel = ViewModelProvider(
                this,
                factory
            )[FavoriteViewModel::class.java]

            val movieAdapter = MovieAdapter()

            fragmentFavoriteMoviesBinding.progressBar.progressView.visibility = View.VISIBLE

            viewModel.getFavoriteMovie().observe(this, { movies ->
                fragmentFavoriteMoviesBinding.progressBar.progressView.visibility = View.GONE
                movieAdapter.submitList(movies)
            })

            with(fragmentFavoriteMoviesBinding.rvFavoriteMovie) {
                this.layoutManager = LinearLayoutManager(context)
                this.setHasFixedSize(true)
                this.adapter = movieAdapter
            }
        }
    }

}