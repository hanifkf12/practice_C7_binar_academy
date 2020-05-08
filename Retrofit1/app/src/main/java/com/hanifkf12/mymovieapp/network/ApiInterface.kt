package com.hanifkf12.mymovieapp.network

import com.hanifkf12.mymovieapp.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("movie/popular")
    fun getMovies(@Query("api_key") apiKey : String) : Call<MovieResponse>
}