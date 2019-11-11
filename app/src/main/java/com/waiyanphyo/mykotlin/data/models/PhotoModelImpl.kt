package com.waiyanphyo.mykotlin.data.models

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.waiyanphyo.mykotlin.data.vos.PhotoVO
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object PhotoModelImpl : BaseModel(), PhotoModel {

    override fun getAllPhotoFromNetwork(
        onFailure: (String) -> Unit
    ): LiveData<List<PhotoVO>> {

        dataAgent.getAllPhotosObservable()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError {
                onFailure(it.message?:"Response error")
            }
            .flatMap<LongArray> {
                room.photoDao().insertAllPhotos(it).subscribeOn(Schedulers.io()).toObservable()
            }
            .subscribe({
                Log.d("test---",it.toString())
            },
                {
                    onFailure(it.localizedMessage)
                })

//            dataAgent.getAllPhotos(
//                {
//                    room.photoDao().insertAllPhotos(it)
//                },{
//                    onFailure(it)
//                })
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

    }

}