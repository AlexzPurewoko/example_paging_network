package com.example.examplepaging.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.examplepaging.data.MovieItemResponse
import com.example.examplepaging.databinding.ItemMovieBinding

class MovieAdapter(
    diffCallback: DiffUtil.ItemCallback<MovieItemResponse>
): PagingDataAdapter<MovieItemResponse, MovieVH>(diffCallback){

    override fun onBindViewHolder(holder: MovieVH, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieVH {
        return MovieVH(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}

class MovieVH(
    private val binding: ItemMovieBinding
): RecyclerView.ViewHolder(binding.root) {
    fun bind(itemMovie: MovieItemResponse){
        binding.movieTitle.text = itemMovie.title
        binding.description.text = itemMovie.overview
        binding.rating.text = "Rating: ${itemMovie.voteAverage}"
        Glide.with(binding.root.context).load(itemMovie.posterPath.let { "https://image.tmdb.org/t/p/w342$it" }).into(binding.moviePoster)
    }
}

