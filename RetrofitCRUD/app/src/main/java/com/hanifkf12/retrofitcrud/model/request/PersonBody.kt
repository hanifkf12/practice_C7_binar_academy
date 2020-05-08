package com.hanifkf12.retrofitcrud.model.request


import com.google.gson.annotations.SerializedName

data class PersonBody(
    @SerializedName("first_name")
    var firstName: String? = null,
    
    @SerializedName("last_name")
    var lastName: String? = null
)