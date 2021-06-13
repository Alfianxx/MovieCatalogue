package com.alfian.moviecatalogue.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alfian.moviecatalogue.adapter.TvShowAdapter
import com.alfian.moviecatalogue.databinding.FragmentFavoriteTvBinding
import com.alfian.moviecatalogue.viewmodel.FavoriteViewModel
import com.alfian.moviecatalogue.viewmodel.ViewModelFactory

class FavoriteTvShowFragment : Fragment() {

    private lateinit var fragmentFavoriteTvBinding: FragmentFavoriteTvBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentFavoriteTvBinding = FragmentFavoriteTvBinding.inflate(layoutInflater, container, false)
        return fragmentFavoriteTvBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())

            val viewModel = ViewModelProvider(
                this,
                factory
            )[FavoriteViewModel::class.java]

            val tvShowAdapter = TvShowAdapter()

            fragmentFavoriteTvBinding.progressBar.progressView.visibility = View.VISIBLE

            viewModel.getFavoriteTv().observe(this, { tvShow ->
                fragmentFavoriteTvBinding.progressBar.progressView.visibility = View.GONE
                tvShowAdapter.submitList(tvShow)
            })

            with(fragmentFavoriteTvBinding.rvFavoriteTv) {
                this.layoutManager = LinearLayoutManager(context)
                this.setHasFixedSize(true)
                this.adapter = tvShowAdapter
            }
        }
    }

}