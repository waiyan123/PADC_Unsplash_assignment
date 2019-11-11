package com.waiyanphyo.mykotlin

import android.app.Application
import android.content.Context
import com.waiyanphyo.mykotlin.data.models.PhotoModelImpl

class MainApplication : Application(){

     companion object {
         fun getContext() : Context = this.getContext()
     }

    override fun onCreate() {
        super.onCreate()
        PhotoModelImpl.initDatabase(applicationContext)


    }

}