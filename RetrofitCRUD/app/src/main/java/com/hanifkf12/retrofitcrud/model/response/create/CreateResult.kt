package com.hanifkf12.retrofitcrud.model.response.create


import com.google.gson.annotations.SerializedName

data class CreateResult(
    @SerializedName("CreatedAt")
    val createdAt: String?,
    @SerializedName("DeletedAt")
    val deletedAt: Any?,
    @SerializedName("first_name")
    val firstName: String?,
    @SerializedName("ID")
    val iD: Int?,
    @SerializedName("last_name")
    val lastName: String?,
    @SerializedName("UpdatedAt")
    val updatedAt: String?
)