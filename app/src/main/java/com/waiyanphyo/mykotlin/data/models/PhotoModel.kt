package com.waiyanphyo.mykotlin.data.models

import androidx.lifecycle.LiveData
import com.waiyanphyo.mykotlin.data.vos.PhotoVO

interface PhotoModel {

    fun getAllPhotoFromNetwork(
        onFailure : (String) -> Unit
    ) : LiveData<List<PhotoVO>>

    fun getPhotoById(id:String): LiveData<PhotoVO>

    fun getSearchPhotos(
        onSuccess: (List<PhotoVO>) -> Unit,
        onFailure: (String) -> Unit
    )

}