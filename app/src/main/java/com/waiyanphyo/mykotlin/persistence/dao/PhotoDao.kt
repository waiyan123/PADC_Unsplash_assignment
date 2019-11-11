package com.waiyanphyo.mykotlin.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.waiyanphyo.mykotlin.data.vos.PhotoVO
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
abstract class PhotoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertAllPhotos(list : List<PhotoVO>) : Single<LongArray>

    @Query("SELECT * FROM `photo table`")
    abstract fun getPhotoList() : LiveData<List<PhotoVO>>

    //Blocking function
    @Query("SELECT * FROM `photo table`")
    abstract fun getPhotoListBlocking() : Maybe<List<PhotoVO>>

    @Query("SELECT * FROM `photo table` WHERE id = :id")
    abstract fun getPhotoById(id : String) : LiveData<PhotoVO>

}