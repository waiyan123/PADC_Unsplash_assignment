package com.waiyanphyo.mykotlin.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.waiyanphyo.mykotlin.R
import com.waiyanphyo.mykotlin.data.vos.PhotoVO
import com.waiyanphyo.mykotlin.delegates.PhotoDelegate
import com.waiyanphyo.mykotlin.views.holders.PhotoViewHolder

class PhotoAdapter(private val delegate : PhotoDelegate) : BaseRecyclerAdapter<PhotoViewHolder,PhotoVO>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view,parent,false)
        return PhotoViewHolder(view,delegate)
    }
}