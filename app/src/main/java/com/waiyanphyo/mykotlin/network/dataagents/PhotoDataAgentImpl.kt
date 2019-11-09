package com.waiyanphyo.mykotlin.network.dataagents

import android.util.Log
import com.waiyanphyo.mykotlin.data.vos.PhotoVO
import com.waiyanphyo.mykotlin.network.PhotoApi
import com.waiyanphyo.mykotlin.utils.API_KEY
import com.waiyanphyo.mykotlin.utils.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object PhotoDataAgentImpl : PhotosDataAgent {

    private val photoApi : PhotoApi
    init {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(15,TimeUnit.SECONDS)
            .writeTimeout(60,TimeUnit.SECONDS)
            .readTimeout(60,TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        photoApi = retrofit.create(PhotoApi::class.java)
    }

    override fun getAllPhotos(
        onSuccess: (List<PhotoVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        val call = photoApi.getAllPhotos(API_KEY)
        call.enqueue(object : Callback<List<PhotoVO>> {
            override fun onFailure(call: Call<List<PhotoVO>>, t: Throwable) {
                onFailure(t.localizedMessage)
            }

            override fun onResponse(call: Call<List<PhotoVO>>, response: Response<List<PhotoVO>>) {
                if(response.isSuccessful){
                    if(response.body()!=null){
                        onSuccess(response.body()!!)
                    }
                }
            }

        })
    }

    override fun getPhotoById(
        id : (String) -> Unit,
        onSuccess: (PhotoVO) -> Unit,
        onFailure: (String) -> Unit
    ) {
        val call = photoApi.getPhotoById(id,API_KEY)
        call.enqueue(object : Callback<PhotoVO>{
            override fun onFailure(call: Call<PhotoVO>, t: Throwable) {
                onFailure(t.localizedMessage)
            }

            override fun onResponse(call: Call<PhotoVO>, response: Response<PhotoVO>) {
                if(response.isSuccessful){
                    onSuccess(response.body()!!)
                }
            }

        })
    }

    override fun getSearchPhotos(
        onSuccess: (List<PhotoVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {

    }

}