package com.hanifkf12.retrofitcrud.model.response.create


import com.google.gson.annotations.SerializedName

data class CreateResponse(
    @SerializedName("result")
    val result: CreateResult?
)