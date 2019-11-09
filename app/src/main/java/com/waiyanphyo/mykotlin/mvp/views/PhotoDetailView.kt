package com.waiyanphyo.mykotlin.mvp.views

import com.waiyanphyo.mykotlin.data.vos.PhotoVO

interface PhotoDetailView : BaseView {

    fun displayPhoto(photoVO : PhotoVO)

    fun displayError(errorMessage : String)

}