package com.waiyanphyo.mykotlin.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.waiyanphyo.mykotlin.R
import com.waiyanphyo.mykotlin.adapters.PhotoAdapter
import com.waiyanphyo.mykotlin.data.vos.PhotoVO
import com.waiyanphyo.mykotlin.mvp.presenters.PhotoDetailPresenter
import com.waiyanphyo.mykotlin.mvp.views.PhotoDetailView
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.bottom_sheet_content.*
import kotlinx.android.synthetic.main.item_recycler_view.view.*


class DetailsActivity : BaseActivity(),PhotoDetailView {

    lateinit var mPresenter : PhotoDetailPresenter
    lateinit var rvAdapter : PhotoAdapter

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

        rv_details.setHasFixedSize(true)
        rv_details.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        rvAdapter = PhotoAdapter(mPresenter)
        rv_details.adapter = rvAdapter

        mPresenter.onCreate()
        mPresenter.getPhotoById(intent.getStringExtra(EXTRA_EVENT_ID)!!)
        mPresenter.getPhotos()
    }

    override fun displayAllPhotos(photoList: List<PhotoVO>) {
        rvAdapter.setNewData(photoList)
    }

    override fun displayPhoto(photoVO: PhotoVO) {
        Glide.with(this)
            .load(photoVO.urls.regular)
            .into(img_detail)
        Glide.with(this)
            .load(photoVO.user.profile_image.small)
            .into(img_profile)
        tv_user_name.text = photoVO.user.name
    }

    override fun displayError(errorMessage: String) {
        Toast.makeText(this,errorMessage,Toast.LENGTH_SHORT).show()
    }
}