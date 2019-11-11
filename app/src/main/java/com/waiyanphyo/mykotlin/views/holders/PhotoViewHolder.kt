package com.waiyanphyo.mykotlin.views.holders

import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import android.view.WindowManager
import com.bumptech.glide.Glide
import com.waiyanphyo.mykotlin.data.vos.PhotoVO
import com.waiyanphyo.mykotlin.delegates.PhotoDelegate
import kotlinx.android.synthetic.main.item_recycler_view.view.*

class PhotoViewHolder(itemView : View,delegate : PhotoDelegate ) : BaseViewHolder<PhotoVO>(itemView){

    init {
        itemView.setOnClickListener{
            mData?.id?.let {
                delegate.onTabItem(it)
            }
        }
    }

    override fun bindData(data: PhotoVO) {
        itemView.img_itemview.heightRatio = data.height.toDouble()/data.width.toDouble()
        Glide.with(itemView)
            .load(data.urls.regular)
            .into(itemView.img_itemview)

    }
}