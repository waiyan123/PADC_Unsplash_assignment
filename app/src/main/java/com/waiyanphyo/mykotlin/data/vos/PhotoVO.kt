package com.waiyanphyo.mykotlin.data.vos

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "photo table")
data class PhotoVO(

    @SerializedName("id")
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id : String,


    @SerializedName("created_at")
    @ColumnInfo(name = "created_at")
    val created_at : String,

    @SerializedName("updated_at")
    @ColumnInfo(name = "updated_at")
    val updated_at : String,

    @SerializedName("promoted_at")
    @ColumnInfo(name = "promoted_at")
    val promoted_at: String?,

    @SerializedName("width")
    @ColumnInfo(name = "width")
    val width : Int,

    @SerializedName("height")
    @ColumnInfo(name = "height")
    val height : Int,

    @SerializedName("color")
    @ColumnInfo(name = "color")
    val color : String,

    @SerializedName("description")
    @ColumnInfo(name = "description")
    val description : String?,

    @SerializedName("alt_description")
    @ColumnInfo(name = "alt_description")
    val alt_description : String?,

    @SerializedName("urls")
    @ColumnInfo(name =  "urls")
    val urls : UrlVO,

    @SerializedName("links")
    @ColumnInfo(name =  "links")
    val links : LinksVO,

    @SerializedName("categories")
    @Embedded(prefix =  "categories")
    val categories : ArrayList<String>?,

    @SerializedName("likes")
    @ColumnInfo(name = "likes")
    val likes : Int,

    @SerializedName("liked_by_user")
    @ColumnInfo(name = "liked_by_user")
    val liked_by_user : Boolean,

    @SerializedName("current_user_collections")
    @Embedded(prefix =  "current_user_collections")
    val current_user_collections : ArrayList<String>?,

    @SerializedName("user")
    @ColumnInfo(name =  "user")
    val user : UserVO

) {
}