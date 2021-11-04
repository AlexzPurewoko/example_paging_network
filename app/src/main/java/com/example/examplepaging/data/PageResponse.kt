package com.example.examplepaging.data

import com.google.gson.annotations.SerializedName

data class PageResponse(

    @field:SerializedName("page")
    val page: Int,

    @field:SerializedName("total_pages")
    val totalPages: Int,

    @field:SerializedName("results")
    val results: List<MovieItemResponse>,

    @field:SerializedName("total_results")
    val totalResults: Int
)