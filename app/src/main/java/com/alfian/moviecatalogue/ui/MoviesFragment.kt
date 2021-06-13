package com.alfian.moviecatalogue.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alfian.moviecatalogue.adapter.MovieAdapter
import com.alfian.moviecatalogue.viewmodel.MovieViewModel
import com.alfian.moviecatalogue.databinding.FragmentMoviesBinding
import com.alfian.moviecatalogue.viewmodel.ViewModelFactory
import com.alfian.moviecatalogue.vo.Status

class MoviesFragment : Fragment() {

    private lateinit var fragmentMoviesBinding: FragmentMoviesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentMoviesBinding = FragmentMoviesBinding.inflate(layoutInflater, container, false)
        return fragmentMoviesBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())

            val viewModel = ViewModelProvider(
                this,
                factory
            )[MovieViewModel::class.java]

            val movieAdapter = MovieAdapter()

            fragmentMoviesBinding.progressBar.progressView.visibility = View.VISIBLE
            viewModel.getMovie().observe(this, { movie ->

                if (movie != null) {
                    when (movie.status) {
                        Status.LOADING -> fragmentMoviesBinding.progressBar.progressView.visibility =
                            View.VISIBLE
                        Status.SUCCESS -> {
                            fragmentMoviesBinding.progressBar.progressView.visibility = View.GONE
                            movieAdapter.submitList(movie.data)
                        }
                        Status.ERROR -> {
                            fragmentMoviesBinding.progressBar.progressView.visibility = View.GONE
                            Toast.makeText(context, "Something wrong", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            with(fragmentMoviesBinding.rvMovie) {
                this.layoutManager = LinearLayoutManager(context)
                this.setHasFixedSize(true)
                this.adapter = movieAdapter
            }
        }
    }

}