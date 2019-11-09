package com.waiyanphyo.mykotlin.adapters

import androidx.recyclerview.widget.RecyclerView
import com.waiyanphyo.mykotlin.data.vos.PhotoVO
import com.waiyanphyo.mykotlin.views.holders.BaseViewHolder

abstract class BaseRecyclerAdapter<VH : BaseViewHolder<T>,T> : RecyclerView.Adapter<VH>() {

    var itemList : MutableList<T> = ArrayList()

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.mData = itemList[position]

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun setNewData(list : List<T>){
        itemList = list.toMutableList()
        notifyDataSetChanged()
    }

    fun appendNewData(list : List<T>){
        itemList.addAll(list.toMutableList())
        notifyDataSetChanged()
    }
}