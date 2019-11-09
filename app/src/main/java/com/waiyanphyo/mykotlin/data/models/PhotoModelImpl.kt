package com.waiyanphyo.mykotlin.data.models

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.waiyanphyo.mykotlin.data.vos.PhotoVO

object PhotoModelImpl : BaseModel(),PhotoModel {

    override fun getAllPhotoFromNetwork(
        onFailure: (String) -> Unit
    ) : LiveData<List<PhotoVO>> {
        val photosFromDb = room.photoDao().getPhotoList()
            dataAgent.getAllPhotos(
                {
                    room.photoDao().insertAllPhotos(it)
                },{
                    onFailure(it)
                })
        return room.photoDao().getPhotoList()

    }

    override fun getPhotoById(id: String): LiveData<PhotoVO> {
//        return room.photoDao().getPhotoById(id)
        return Transformations.distinctUntilChanged(room.photoDao().getPhotoById(id)) // LiveData transformations
    }

    override fun getSearchPhotos(
        onSuccess: (List<PhotoVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        dataAgent.getSearchPhotos(
            {
                onSuccess(it)
            },
            {
                onFailure(it)
            })
    }

}