package com.waiyanphyo.mykotlin.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.waiyanphyo.mykotlin.data.models.PhotoModelImpl

abstract class BaseActivity : AppCompatActivity(){

    protected lateinit var model : PhotoModelImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = PhotoModelImpl
    }
}