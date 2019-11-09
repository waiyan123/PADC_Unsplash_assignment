package com.waiyanphyo.mykotlin.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.waiyanphyo.mykotlin.R
import com.waiyanphyo.mykotlin.data.vos.PhotoVO
import com.waiyanphyo.mykotlin.mvp.presenters.PhotoDetailPresenter
import com.waiyanphyo.mykotlin.mvp.views.PhotoDetailView
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.bottom_sheet_content.*
import kotlinx.android.synthetic.main.item_recycler_view.view.*


class DetailsActivity : BaseActivity(),PhotoDetailView {

    lateinit var mPresenter : PhotoDetailPresenter

    companion object {
        const val EXTRA_EVENT_ID = "Extra_to_extra"
        fun newIntent(context : Context, id : String ) : Intent {
            return Intent(context,DetailsActivity::class.java).apply {
                putExtra(EXTRA_EVENT_ID,id)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        mPresenter = PhotoDetailPresenter()
        mPresenter.initPresenter(this)
        mPresenter.onCreate()
        mPresenter.getPhotoById(intent.getStringExtra(EXTRA_EVENT_ID)!!)
    }

    override fun displayPhoto(photoVO: PhotoVO) {
        Glide.with(this)
            .load(photoVO.urls.regular)
            .into(img_detail)
    }

    override fun displayError(errorMessage: String) {

    }
}