package com.hanifkf12.mymovieapp.repository

import com.hanifkf12.mymovieapp.model.MovieResponse
import com.hanifkf12.mymovieapp.model.Result
import com.hanifkf12.mymovieapp.network.ApiResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepository {
    companion object{
        const val apiKey = "62c2686de74ac057a61bf229a428f93d"
    }
    fun getMovies(onResult : (MovieResponse) -> Unit,  onError : (Throwable)->Unit){
        ApiResource.create().getMovies(apiKey).enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                onError(t)
            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.code()==200){
                    onResult(response.body()!!)
                }
            }

        })
    }
}