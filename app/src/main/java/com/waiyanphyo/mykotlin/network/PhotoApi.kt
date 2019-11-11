package com.waiyanphyo.mykotlin.network

import com.waiyanphyo.mykotlin.data.vos.PhotoVO
import com.waiyanphyo.mykotlin.network.responses.SearchResponse
import com.waiyanphyo.mykotlin.utils.GET_PHOTOS
import com.waiyanphyo.mykotlin.utils.GET_PHOTO_BY_ID
import com.waiyanphyo.mykotlin.utils.GET_SEARCH_PHOTOS
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.*

interface PhotoApi {

    @GET(GET_PHOTOS)
    fun getAllPhotos(@Query("client_id") client_id : String) : Call<List<PhotoVO>>

    //Observable
    @GET(GET_PHOTOS)
    fun getAllPhotosObservable(@Query("client_id") client_id : String) : Observable<List<PhotoVO>>

    @GET(GET_PHOTO_BY_ID)
    fun getPhotoById(@Path("id") id: (String) -> Unit, @Query("client_id") client_id: String) : Call<PhotoVO>

    @GET(GET_SEARCH_PHOTOS)
    fun getSearchPhotos(@Query("client_id") client_id: String,@Query("query") office : String ) : Observable<SearchResponse>

}