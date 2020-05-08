package com.hanifkf12.retrofitcrud.model.response.update


import com.google.gson.annotations.SerializedName
import com.hanifkf12.retrofitcrud.model.response.update.Data

data class UpdateResponse(
    @SerializedName("data")
    val `data`: Data?,
    @SerializedName("result")
    val result: String?
)