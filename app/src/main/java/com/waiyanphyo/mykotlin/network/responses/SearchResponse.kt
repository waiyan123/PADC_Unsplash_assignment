package com.waiyanphyo.mykotlin.network.responses

import com.google.gson.annotations.SerializedName
import com.waiyanphyo.mykotlin.data.vos.PhotoVO
import com.waiyanphyo.mykotlin.utils.GET_PHOTOS

data class SearchResponse(

    @SerializedName("total")
    val total : Int,

    @SerializedName("total_pages")
    val total_pages : Int,

    @SerializedName("results")
    val results : List<PhotoVO>


)
{
}