package com.waiyanphyo.mykotlin.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.waiyanphyo.mykotlin.data.vos.LinksVO
import com.waiyanphyo.mykotlin.data.vos.SponsorshipVO
import com.waiyanphyo.mykotlin.data.vos.UrlVO
import com.waiyanphyo.mykotlin.data.vos.UserVO

class MyTypeConverter {


    //for UrlVO
    @TypeConverter
    fun toUrlVOString(urlVO: UrlVO) : String {
        return Gson().toJson(urlVO)
    }

    @TypeConverter
    fun toUrlVO(json : String) : UrlVO {
        val typeToken = object : TypeToken<UrlVO>(){

        }.type
        return Gson().fromJson(json,typeToken)
    }


    //for LinksVO
    @TypeConverter
    fun toLinksVOString(linksVO: LinksVO) : String {
        return Gson().toJson(linksVO)
    }

    @TypeConverter
    fun toLinksVO(json : String) : LinksVO {
        val typeToken = object : TypeToken<LinksVO>(){

        }.type
        return Gson().fromJson(json,typeToken)
    }

    //for List<String>categories
//    @TypeConverter
//    fun toCategoryString(list: List<UserVO>): String{
//        return Gson().toJson(list)
//    }
//
//    @TypeConverter
//    fun toCategoryList(json: String): List<UserVO> {
//        val typeToken = object : TypeToken<List<UserVO>>(){
//
//        }.type
//        return Gson().fromJson(json, typeToken)
//    }

    //for UserVO
    @TypeConverter
    fun toUserVOString(userVO: UserVO) : String {
        return Gson().toJson(userVO)
    }

    @TypeConverter
    fun toUserVO(json : String) : UserVO {
        val typeToken = object : TypeToken<UserVO>(){

        }.type
        return Gson().fromJson(json,typeToken)
    }

    //for SponsorshipVO
    @TypeConverter
    fun toSponsorshipVOString(sponsorshipVO: SponsorshipVO) : String {
        return Gson().toJson(sponsorshipVO)
    }

    @TypeConverter
    fun toSponsorshipVO(json : String) : SponsorshipVO {
        val typeToken = object : TypeToken<SponsorshipVO>(){

        }.type
        return Gson().fromJson(json,typeToken)
    }

}