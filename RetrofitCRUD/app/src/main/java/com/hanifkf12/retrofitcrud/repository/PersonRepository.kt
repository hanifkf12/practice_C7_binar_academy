package com.hanifkf12.retrofitcrud.repository

import com.hanifkf12.retrofitcrud.model.request.PersonBody
import com.hanifkf12.retrofitcrud.model.response.create.CreateResponse
import com.hanifkf12.retrofitcrud.model.response.update.UpdateResponse
import com.hanifkf12.retrofitcrud.network.ApiResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PersonRepository {
    fun createPerson(personBody: PersonBody, onResult : (CreateResponse)->Unit, onError : (Throwable)->Unit ){
        ApiResource.create().createPerson(personBody).enqueue(object : Callback<CreateResponse>{
            override fun onFailure(call: Call<CreateResponse>, t: Throwable) {
                onError(t)
            }

            override fun onResponse(
                call: Call<CreateResponse>,
                response: Response<CreateResponse>
            ) {
                if(response.code() == 201){
                    onResult(response.body()!!)
                }
            }

        })
    }
    fun updatePerson(id : String, personBody: PersonBody, onResult : (UpdateResponse)->Unit, onError : (Throwable)->Unit){
        ApiResource.create().updatePerson(id, personBody).enqueue(object : Callback<UpdateResponse>{
            override fun onFailure(call: Call<UpdateResponse>, t: Throwable) {
                onError(t)
            }

            override fun onResponse(
                call: Call<UpdateResponse>,
                response: Response<UpdateResponse>
            ) {
                if (response.code() == 200){
                    onResult(response.body()!!)
                }
            }

        })
    }

    fun getPersonById(id : String, onResult : (CreateResponse)->Unit, onError : (Throwable)->Unit ){
        ApiResource.create().getPersonById(id).enqueue(object : Callback<CreateResponse>{
            override fun onFailure(call: Call<CreateResponse>, t: Throwable) {
                onError(t)
            }

            override fun onResponse(
                call: Call<CreateResponse>,
                response: Response<CreateResponse>
            ) {
                if(response.code()==200){
                    onResult(response.body()!!)
                }
            }

        })
    }
}