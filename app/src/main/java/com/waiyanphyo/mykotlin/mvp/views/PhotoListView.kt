package com.waiyanphyo.mykotlin.mvp.views

import com.waiyanphyo.mykotlin.data.vos.PhotoVO

interface PhotoListView : BaseView{

    fun displayPhotoList(list : List<PhotoVO>)

    fun displayError(errorMessage : String)

    fun navigateToDetail(plantId : String)
}