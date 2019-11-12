package com.waiyanphyo.mykotlin.mvp.presenters

import android.util.Log
import com.waiyanphyo.mykotlin.data.models.PhotoModelImpl
import com.waiyanphyo.mykotlin.data.vos.PhotoVO
import com.waiyanphyo.mykotlin.delegates.PhotoDelegate
import com.waiyanphyo.mykotlin.mvp.views.PhotoListView
import com.waiyanphyo.mykotlin.network.dataagents.PhotoDataAgentImpl
import com.waiyanphyo.mykotlin.network.responses.SearchResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

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

    fun onSearch(str : String){
        Log.d("test---","onSearch str "+str)
        val dataAgent = PhotoDataAgentImpl
        dataAgent.getSearchPhotosObservable {

        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext {
                mView.displayPhotoList(it.results)
            }
            .subscribe()
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