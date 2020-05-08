package com.hanifkf12.retrofitcrud.network

import com.hanifkf12.retrofitcrud.model.request.PersonBody
import com.hanifkf12.retrofitcrud.model.response.create.CreateResponse
import com.hanifkf12.retrofitcrud.model.response.update.UpdateResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {
    @POST("person")
    fun createPerson(@Body personBody: PersonBody) : Call<CreateResponse>

    @PUT("person/{id}")
    fun updatePerson(@Path("id") id : String, @Body personBody: PersonBody) : Call<UpdateResponse>

    @GET("person/{id}")
    fun getPersonById(@Path("id") id : String) : Call<CreateResponse>


}