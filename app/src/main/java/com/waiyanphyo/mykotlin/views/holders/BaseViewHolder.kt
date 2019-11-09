package com.waiyanphyo.mykotlin.views.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(itemView : View) : RecyclerView.ViewHolder(itemView) {

    var mData : T?=null
    set(value) {
        field = value
        value?.let {
            bindData(it)
        }
        if(value!=null){
            bindData(value)
        }
    }

    protected abstract fun bindData(data : T)
}