package com.alfian.moviecatalogue.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.alfian.moviecatalogue.ui.DetailFilmActivity
import com.alfian.moviecatalogue.data.MovieEntity
import com.alfian.moviecatalogue.databinding.ItemMovieBinding
import com.bumptech.glide.Glide

class MovieAdapter : PagedListAdapter<MovieEntity, MovieAdapter.MovieViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.movieId == newItem.movieId
            }

            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemMovieBinding =
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemMovieBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)

        movie?.let { mov ->
            holder.bind(mov)
        }
    }

    class MovieViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieEntity) {
            with(binding) {
                tvItemTitle.text = movie.title
                tvGenre.text = movie.genre
                tvDuration.text = movie.duration

                Glide.with(itemView.context)
                    .load(movie.poster)
                    .into(imgPoster)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailFilmActivity::class.java)
                    intent.putExtra(DetailFilmActivity.EXTRA_MOVIE, movie.movieId)
                    intent.putExtra(DetailFilmActivity.EXTRA_CHECK, true)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}