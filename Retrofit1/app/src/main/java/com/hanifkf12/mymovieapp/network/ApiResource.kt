package com.hanifkf12.mymovieapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiResource {
        fun create() : ApiInterface{

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(ApiInterface::class.java)
    }
}