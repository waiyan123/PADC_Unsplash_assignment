package com.waiyanphyo.mykotlin.network.dataagents

import com.waiyanphyo.mykotlin.data.vos.PhotoVO

interface PhotosDataAgent {

    fun getAllPhotos(
        onSuccess : (List<PhotoVO>)-> Unit,
        onFailure : (String) -> Unit
    )

    fun getPhotoById(
        id : (String) ->Unit,
        onSuccess : (PhotoVO)-> Unit,
        onFailure: (String) -> Unit
    )

    fun getSearchPhotos(
        onSuccess: (List<PhotoVO>) -> Unit,
        onFailure: (String) -> Unit
    )

}