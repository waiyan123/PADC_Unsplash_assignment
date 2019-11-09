package com.waiyanphyo.mykotlin.data.vos

import com.google.gson.annotations.SerializedName

data class UrlVO(

    @SerializedName("raw")
    val raw : String,

    @SerializedName("full")
    val full : String,

    @SerializedName("regular")
    val regular : String,

    @SerializedName("small")
    val small : String,

    @SerializedName("thumb")
    val thumb : String
)

{
}