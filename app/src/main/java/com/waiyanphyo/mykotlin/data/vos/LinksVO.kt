package com.waiyanphyo.mykotlin.data.vos

import com.google.gson.annotations.SerializedName

data class LinksVO(
    @SerializedName("self")
    val self : String,

    @SerializedName("html")
    val html : String,

    @SerializedName("download")
    val download : String ,

    @SerializedName("download_location")
    val download_location : String,

    @SerializedName("photos")
    val photos : String,

    @SerializedName("likes")
    val likes : String,

    @SerializedName("portfolio")
    val portfolio : String,

    @SerializedName("following")
    val following : String ,

    @SerializedName("followers")
    val followers : String
) {
}