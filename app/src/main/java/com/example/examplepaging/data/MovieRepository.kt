package com.example.examplepaging.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieRepository {

    private val movieApi: MovieApi = Retrofit.Builder().apply {
        baseUrl("https://api.themoviedb.org/3/")
        addConverterFactory(GsonConverterFactory.create(Gson()))
    }.build().create(MovieApi::class.java)

    fun getPopularMovie() = Pager(
        config = PagingConfig(pageSize = 20),
        initialKey = 1,
        pagingSourceFactory = { return@Pager MoviePagingSource(movieApi) }
    ).flow

}