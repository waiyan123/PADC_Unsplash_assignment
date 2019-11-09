package com.waiyanphyo.mykotlin.network

import com.waiyanphyo.mykotlin.data.vos.PhotoVO
import com.waiyanphyo.mykotlin.utils.GET_PHOTOS
import com.waiyanphyo.mykotlin.utils.GET_PHOTO_BY_ID
import retrofit2.Call
import retrofit2.http.*

interface PhotoApi {

    @GET(GET_PHOTOS)
    fun getAllPhotos(@Query("client_id") client_id : String) : Call<List<PhotoVO>>

    @GET(GET_PHOTO_BY_ID)
    fun getPhotoById(@Path("id") id: (String) -> Unit, @Query("client_id") client_id: String) : Call<PhotoVO>

//    @POST(LOGIN)
//    @FormUrlEncoded
//    fun login(@Field(PARAM_ACCESS_TOKEN)accessToken: String, @Field("email") email :String, @Field("password") password : String) : Call<LoginResponse>

}