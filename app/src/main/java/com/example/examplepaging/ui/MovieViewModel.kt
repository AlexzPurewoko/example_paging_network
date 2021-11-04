package com.example.examplepaging.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.examplepaging.data.MovieRepository

class MovieViewModel: ViewModel() {

    private val repository = MovieRepository()

    fun getPopMovies() = repository.getPopularMovie()
        .asLiveData(viewModelScope.coroutineContext)
}