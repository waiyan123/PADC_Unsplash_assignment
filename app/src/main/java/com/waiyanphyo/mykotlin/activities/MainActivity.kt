package com.waiyanphyo.mykotlin.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.waiyanphyo.mykotlin.R
import com.waiyanphyo.mykotlin.adapters.PhotoAdapter
import com.waiyanphyo.mykotlin.data.models.PhotoModelImpl
import com.waiyanphyo.mykotlin.data.vos.PhotoVO
import com.waiyanphyo.mykotlin.mvp.presenters.PhotoListPresenter
import com.waiyanphyo.mykotlin.mvp.views.PhotoListView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(),PhotoListView {

    lateinit var mPresenter : PhotoListPresenter

    lateinit var photoListAdapter : PhotoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPresenter = PhotoListPresenter()
        mPresenter.initPresenter(this)

        rv_photo.setHasFixedSize(true)
        rv_photo.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
//        rv_photo.layoutManager = LinearLayoutManager(this)
        photoListAdapter = PhotoAdapter(mPresenter)
        rv_photo.adapter = photoListAdapter

        mPresenter.onCreate()


    }

    override fun displayPhotoList(list: List<PhotoVO>) {
        photoListAdapter.setNewData(list)
        Toast.makeText(this,list.size.toString(),Toast.LENGTH_SHORT).show()
    }

    override fun displayError(errorMessage: String) {
        Toast.makeText(this,errorMessage,Toast.LENGTH_SHORT).show()
    }

    override fun navigateToDetail(id: String) {
        Toast.makeText(this,"Start new Activity",Toast.LENGTH_SHORT).show()
        startActivity(DetailsActivity.newIntent(this,id))
    }

    override fun onStart() {
        super.onStart()
        mPresenter.onStart()
    }

    override fun onResume() {
        super.onResume()
        mPresenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        mPresenter.onPause()
    }

    override fun onStop() {
        super.onStop()
        mPresenter.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.onDestroy()
    }




}
