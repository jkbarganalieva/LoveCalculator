package com.geektech.lovecalculator.remote

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

//{
//    "fname": "Jakshilik",
//    "sname": "Janara",
//    "percentage": "63",
//    "result": "All the best!"
//}

@Entity(tableName = "love_model")
data class LoveModel (
    @SerializedName("fname")
    var firstName:String,
    @SerializedName("sname")
    var secondName:String,
    var percentage:String,
    var result:String,
    @PrimaryKey(autoGenerate = true)
    var id:Int?
        )
