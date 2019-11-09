package com.waiyanphyo.mykotlin.network.responses

import com.google.gson.annotations.SerializedName
import com.waiyanphyo.mykotlin.data.vos.PhotoVO
import com.waiyanphyo.mykotlin.utils.GET_PHOTOS

data class PhotoResponse(

    @SerializedName(GET_PHOTOS)
    val photoList : List<PhotoVO>

)
{
}