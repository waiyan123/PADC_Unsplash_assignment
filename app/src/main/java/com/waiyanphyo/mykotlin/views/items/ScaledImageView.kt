package com.waiyanphyo.mykotlin.views.items

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView

class ScaledImageView : AppCompatImageView{
    var heightRatio = 0.0

        set(value) {
            if(value != 0.0){
                field = value
                requestLayout()
            }
        }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        if( heightRatio > 0){
            val width = MeasureSpec.getSize(widthMeasureSpec)
            val height: Int = (width * heightRatio).toInt()
            setMeasuredDimension(width, height)
        }else{
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        }
    }

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
}