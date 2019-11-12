package com.waiyanphyo.mykotlin.network.dataagents

import com.waiyanphyo.mykotlin.data.vos.PhotoVO
import com.waiyanphyo.mykotlin.network.responses.SearchResponse
import io.reactivex.Observable

interface PhotosDataAgent {

    fun getAllPhotos(
        onSuccess : (List<PhotoVO>)-> Unit,
        onFailure : (String) -> Unit
    )

    fun getAllPhotosObservable() : Observable<List<PhotoVO>>

    fun getPhotoById(
        id : String,
        onSuccess : (PhotoVO)-> Unit,
        onFailure: (String) -> Unit
    )

    fun getSearchPhotosObservable(queryStr : String): Observable<SearchResponse>

}