package com.waiyanphyo.mykotlin.activities

import android.os.AsyncTask
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.waiyanphyo.mykotlin.R
import com.waiyanphyo.mykotlin.adapters.PhotoAdapter
import com.waiyanphyo.mykotlin.data.vos.PhotoVO
import com.waiyanphyo.mykotlin.mvp.presenters.PhotoListPresenter
import com.waiyanphyo.mykotlin.mvp.views.PhotoListView
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.disposables.Disposables
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : BaseActivity(),PhotoListView {

    lateinit var mPresenter : PhotoListPresenter

    lateinit var photoListAdapter : PhotoAdapter

    lateinit var asyncTask : AsyncTask<Void,Void,String>

    lateinit var disposable : Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPresenter = PhotoListPresenter()
        mPresenter.initPresenter(this)

        rv_photo.setHasFixedSize(true)
        rv_photo.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        photoListAdapter = PhotoAdapter(mPresenter)
        rv_photo.adapter = photoListAdapter

        mPresenter.onCreate()

//        val observableForEditText = Observable.create<String> {
//            et_search.addTextChangedListener(object : TextWatcher{
//                override fun afterTextChanged(p0: Editable?) {
//
//                }
//
//                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//
//                }
//
//                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                    it.onNext(p0.toString())
//                    Log.d("test---","onTextChanged")
//
//                }
//            })
//        }
//            .debounce(2000,TimeUnit.MILLISECONDS)

        disposable = Observable.create<String> { emiter->
            et_search.addTextChangedListener(object : TextWatcher{
                override fun afterTextChanged(p0: Editable?) {

                }

                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    emiter.onNext(p0.toString())
                }

            })
        }
            .debounce(2000,TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext {
                mPresenter.onSearch(it)
            }
            .subscribe()


//        val observer = object : Observer<String> {
//            override fun onComplete() {
//                Log.d("test---","onComplete")
//            }
//
//            override fun onSubscribe(d: Disposable) {
//                Log.d("test---","onSubscribe")
//            }
//
//            override fun onNext(t: String) {
//                mPresenter.onSearch(t)
//                Log.d("test---","onNext")
//                Log.d("test---",t)
//            }
//
//            override fun onError(e: Throwable) {
//                Log.d("test---","onError")
//            }
//        }

//        observableForEditText.subscribe(observer)
    }

    override fun displayPhotoList(list: List<PhotoVO>) {
        photoListAdapter.setNewData(list)
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
        disposable.dispose()
    }




}
