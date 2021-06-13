package com.alfian.moviecatalogue.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alfian.moviecatalogue.adapter.TvShowAdapter
import com.alfian.moviecatalogue.databinding.FragmentTvShowBinding
import com.alfian.moviecatalogue.viewmodel.TvShowViewModel
import com.alfian.moviecatalogue.viewmodel.ViewModelFactory
import com.alfian.moviecatalogue.vo.Status

class TvShowFragment : Fragment() {

    private lateinit var fragmentTvShowBinding: FragmentTvShowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentTvShowBinding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return fragmentTvShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())

            val viewModel = ViewModelProvider(
                this,
                factory
            )[TvShowViewModel::class.java]

            val tvShowAdapter = TvShowAdapter()
            fragmentTvShowBinding.progressBar.progressView.visibility = View.VISIBLE
            viewModel.getTvShow().observe(this, { tvShow ->
                if (tvShow != null) {
                    when(tvShow.status) {
                        Status.LOADING -> fragmentTvShowBinding.progressBar.progressView.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            fragmentTvShowBinding.progressBar.progressView.visibility = View.GONE
                            tvShowAdapter.submitList(tvShow.data)
                        }
                        Status.ERROR ->  {
                            fragmentTvShowBinding.progressBar.progressView.visibility = View.GONE
                            Toast.makeText(context, "Something wrong", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })
            with(fragmentTvShowBinding.rvTvShow) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowAdapter
            }
        }
    }
}