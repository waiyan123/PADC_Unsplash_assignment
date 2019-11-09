package com.waiyanphyo.mykotlin.data.vos

import com.google.gson.annotations.SerializedName

data class SearchVO(

    @SerializedName("total")
    val total : Int,

    @SerializedName("total_pages")
    val tatal_pages : Int,

    @SerializedName("results")
    val listResults : List<PhotoVO>

) {
}