package com.adam.movieapp.core.data.source.remote.network

import com.adam.movieapp.core.data.source.remote.response.ListMovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("movie/popular")
    suspend fun getList(@Query("api_key")q: String): ListMovieResponse
}
