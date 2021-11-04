package com.example.examplepaging.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.examplepaging.data.MovieItemResponse
import java.lang.Exception

class MoviePagingSource(
    private val api: MovieApi
): PagingSource<Int, MovieItemResponse>() {

    override fun getRefreshKey(state: PagingState<Int, MovieItemResponse>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieItemResponse> {
        return try {
            val nextPage = params.key ?: 1

            // TODO: ADD YOUR TMDB API KEY HERE
            val response = api.getPopularMovies("[YOUR TMDB API KEY]", nextPage, "en-US")
            LoadResult.Page(
                data = response.results,
                prevKey = null,
                nextKey = nextPage + 1
            )
        } catch (e: Exception){
            LoadResult.Error(e)
        }
    }
}