package com.example.examplepaging.ui

import androidx.recyclerview.widget.DiffUtil
import com.example.examplepaging.data.MovieItemResponse

object MovieComparator: DiffUtil.ItemCallback<MovieItemResponse>(){

    override fun areItemsTheSame(oldItem: MovieItemResponse, newItem: MovieItemResponse): Boolean {
        return oldItem.id == newItem.id
    }
    override fun areContentsTheSame(
        oldItem: MovieItemResponse,
        newItem: MovieItemResponse
    ): Boolean {
        return oldItem == newItem
    }

}