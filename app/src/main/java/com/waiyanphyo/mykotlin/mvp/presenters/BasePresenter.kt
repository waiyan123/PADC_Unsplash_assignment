package com.waiyanphyo.mykotlin.mvp.presenters

import com.waiyanphyo.mykotlin.mvp.views.BaseView

abstract class BasePresenter<T:BaseView> {

    lateinit var mView : T

    open fun initPresenter(view : T){
        mView = view
    }

    open fun onCreate(){

    }

    open fun onStart(){

    }

    open fun onResume(){

    }

    open fun onPause(){

    }

    open fun onStop(){

    }

    open fun onDestroy(){

    }
}