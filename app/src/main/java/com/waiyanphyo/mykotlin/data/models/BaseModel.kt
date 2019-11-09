package com.waiyanphyo.mykotlin.data.models

import android.content.Context
import com.waiyanphyo.mykotlin.network.dataagents.PhotoDataAgentImpl
import com.waiyanphyo.mykotlin.network.dataagents.PhotosDataAgent
import com.waiyanphyo.mykotlin.persistence.PhotoDatabase

abstract class BaseModel {
    protected val dataAgent = PhotoDataAgentImpl
    protected lateinit var room : PhotoDatabase

    fun initDatabase(context : Context){
        room = PhotoDatabase.getInstance(context)
    }

}