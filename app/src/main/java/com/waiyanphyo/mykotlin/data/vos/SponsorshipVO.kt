package com.waiyanphyo.mykotlin.data.vos

import com.google.gson.annotations.SerializedName

data class SponsorshipVO(

    @SerializedName("impression_urls")
    val impression_urls : ArrayList<String>,

    @SerializedName("impressions_id")
    val impressions_id : String,

    @SerializedName("tagline")
    val tagline : String,

    @SerializedName("sponsor")
    val sponsor : UserVO
) {
}