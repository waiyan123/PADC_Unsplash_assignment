package com.waiyanphyo.mykotlin.mvp.presenters

import android.util.Log
import com.waiyanphyo.mykotlin.data.models.PhotoModelImpl
import com.waiyanphyo.mykotlin.delegates.PhotoDelegate
import com.waiyanphyo.mykotlin.mvp.views.PhotoListView

class PhotoListPresenter : BasePresenter<PhotoListView>(),PhotoDelegate{

    override fun onTabItem(id: String) {
        mView.navigateToDetail(id)
    }

    override fun onCreate() {
        val model = PhotoModelImpl
//        model.getAllPhotoFromNetwork({ photoList ->
//            mView.displayPhotoList(photoList)
//        },
//            { errorMessage->
//                mView.displayError(errorMessage)
//            })
        model.getAllPhotoFromNetwork {
            mView.displayError(it)
        }
            .observeForever {
                mView.displayPhotoList(it)
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