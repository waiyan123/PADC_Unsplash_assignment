package com.waiyanphyo.mykotlin.mvp.presenters

import android.util.Log
import com.waiyanphyo.mykotlin.data.models.PhotoModelImpl
import com.waiyanphyo.mykotlin.data.vos.PhotoVO
import com.waiyanphyo.mykotlin.delegates.PhotoDelegate
import com.waiyanphyo.mykotlin.mvp.views.PhotoDetailView

class PhotoDetailPresenter : BasePresenter<PhotoDetailView>(){

    lateinit var model : PhotoModelImpl

    override fun onCreate() {
        super.onCreate()
        model = PhotoModelImpl

    }

    fun getPhotoById(id : String) {
//        mView.displayPhoto(model.getPhotoById(id))
        model.getPhotoById(id)
            .observeForever {
                mView.displayPhoto(it)
            }
    }

    override fun onStart() {

    }

    override fun onResume() {

    }

    override fun onPause() {

    }

    override fun onStop() {

    }

    override fun onDestroy() {

    }
}