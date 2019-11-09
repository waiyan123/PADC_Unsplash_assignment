package com.waiyanphyo.mykotlin.persistence

import android.content.Context
import androidx.room.*
import com.waiyanphyo.mykotlin.data.vos.PhotoVO
import com.waiyanphyo.mykotlin.persistence.dao.PhotoDao
import com.waiyanphyo.mykotlin.persistence.typeconverters.MyTypeConverter

@Database(entities = [PhotoVO::class],version = 7,exportSchema = false)
@TypeConverters(MyTypeConverter::class)
abstract class PhotoDatabase : RoomDatabase(){

    abstract fun photoDao() : PhotoDao

    companion object {
        private var instance : PhotoDatabase ?= null

        fun getInstance(context : Context) : PhotoDatabase{

            if(instance == null) {
                instance = Room.databaseBuilder(context,
                    PhotoDatabase::class.java,
                    "MyDatabase")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()

            }
            return instance!!
        }
    }


}