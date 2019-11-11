package com.waiyanphyo.mykotlin.mvp.presenters

import android.util.Log
import android.widget.Toast
import com.waiyanphyo.mykotlin.data.models.PhotoModelImpl
import com.waiyanphyo.mykotlin.data.vos.PhotoVO
import com.waiyanphyo.mykotlin.delegates.PhotoDelegate
import com.waiyanphyo.mykotlin.mvp.views.PhotoDetailView
import com.waiyanphyo.mykotlin.utils.API_KEY

class PhotoDetailPresenter : BasePresenter<PhotoDetailView>(),PhotoDelegate{

    override fun onTabItem(id: String) {

    }

    lateinit var model : PhotoModelImpl

    override fun onCreate() {
        super.onCreate()
        model = PhotoModelImpl

    }

    fun getPhotoById(id : String) {
        model.getPhotoById(id)
            .observeForever {
                mView.displayPhoto(it)
            }
    }

    fun getPhotos(){
        model.getAllPhotoFromNetwork {
            mView.displayError(it)
        }
            .observeForever {
                mView.displayAllPhotos(it)
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